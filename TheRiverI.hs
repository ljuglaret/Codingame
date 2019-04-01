import System.IO
import Control.Monad

main :: IO ()
main = do
    hSetBuffering stdout NoBuffering -- DO NOT REMOVE
    
    -- Auto-generated code below aims at helping you parse
    -- the standard input according to the problem statement.
    
    input_line <- getLine
    let r1 = read input_line :: Int
    input_line <- getLine
    let r2 = read input_line :: Int
    
    -- hPutStrLn stderr "Debug messages..."
    
    -- Write answer to stdout
    putStrLn(show(intersection r1 r2))
    return ()
    
    
    
    
decompose :: Int -> Int 
decompose n = 
    let
        aux n2 acc = 
            if (n2 == 0) 
            then acc
            else aux (quot n2 10)  (acc + (mod n2  10)) 
    in aux n 0
           
suite :: Int  -> Int 
suite x = x + (decompose x)

suite5 :: Int -> [Int]
suite5 x = 
    let
        aux l cpt xs = 
            if (cpt == 10) 
            then l 
            else    aux (l++[xs]) (cpt + 1) (suite xs )
    in aux [] 0 x

estDans :: Int -> [Int] -> Bool
estDans x l = any(\elt ->  elt==x)l

intersection :: Int -> Int -> Int 
intersection x y = 
    if (x<y)
    then
        if estDans y (suite5 x)
        then y 
        else intersection (suite x) y
    else 
        if (x>y)
        then intersection y x 
        else x