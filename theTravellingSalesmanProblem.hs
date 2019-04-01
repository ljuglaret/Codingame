import System.IO
import Control.Monad

import Data.List
import Data.Maybe

type Int2 = [(Int,Int)]

valueTab = [] :: [Int]
app [ ] list = list 
app (h:t) list = h:(app t list)

main :: IO ()
main =
    do
    hSetBuffering stdout NoBuffering -- DO NOT REMOVE
    
    -- Auto-generated code below aims at helping you parse
    -- the standard input according to the problem statement.
    
    input_line <- getLine
    let n = read input_line :: Int
    pis<-replicateM n $ do
        input_line <- getLine
        let input = words input_line
        let x = read (input!!0) :: Int    
        let y = read (input!!1) :: Int
        
        return (x,y)
        --return $ app valueTab (x,y)
        
    -- hPutStrLn stderr "Debug messages..."

    -- Write answer to stdout
    --putStrLn  (show pis)
    putStrLn  (show (round(calcule(transforme pis))))

    return ()
    



transforme :: [(Int,Int) ] -> [Ville]
transforme lp =  map (\elt -> Ville {  x = fst elt , y = snd elt }) lp


data Ville = Ville {x:: Int , y ::Int}

    

assemble :: [Int] -> [Int]  -> [Ville]  
assemble l1 l2 = 
    case (l1,l2) of  
        (xv:l1b,yv:l2b) -> (Ville {x = xv,y = yv}):(assemble l1b l2b)
        (_,_) -> []

assemble2 l =     l ++ (take 1 l)




different :: Ville -> Ville -> Bool 
different v1 v2 = ( x v1 /= x v2) || (y v1 /= y v2)



enleveVilleProche :: [Ville] -> [Ville]  
enleveVilleProche l = 
    let
        tete = take 1( listVilleProche l )

    in tete ++ (moins tete  (drop 1 l ))


calcule :: [Ville] -> Float
calcule l = 
    case l of 
        dep:lss -> 
            let
                aux acc l2 =
                    case l2 of 
                        [x] -> acc + (distance x dep)
                        x:ls -> aux (acc + (distCourte l2))  (enleveVilleProche  l2)
                        [] -> acc
            in aux 0 l 
        [] -> 0
        


distance :: Ville -> Ville -> Float
distance v1 v2 = 
    let
        xa = x v1
        ya = y v1
        xb = x  v2 
        yb = y v2
        deltaX = xb - xa
        deltaY= yb - ya
        rep :: Float
        rep =  fromInteger(toInteger(deltaX*deltaX + deltaY*deltaY))
    in rep**0.5

distCourte :: [Ville] -> Float
distCourte l =
    case l of 
        x : ls -> fromMaybe 0 (Just(minimum (map (\elt -> distance elt x) ls)))
        []      -> 0 
        
        
        

listVilleProche :: [Ville] -> [Ville]
listVilleProche l0 = 
    case l0 of
        [] ->  []
        x : l -> 
            let
                aux l1 l2 listeProche  =
                    case (l1,l2) of 
                        (a:ls,b:lds) ->  if b == distCourte l0 then aux ls lds(a:listeProche)  
                                            else aux ls lds listeProche
                        (_, _) -> listeProche 
            in aux l (map (\elt -> distance elt x) l) []
            
moins :: [Ville] -> [Ville] -> [Ville]
moins l1 l2 = 
    if (length  l1 <= length l2) 
    then  
        case l1 of 
            x:ls -> moins ls (filter (\y ->different x y) l2)
            []    -> l2
    else moins l2 l1

