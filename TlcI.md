# Énoncé

Le but de ce puzzle est de prédire le chemin que le personnage prendra dans un labyrinthe en fonction de la topologie des pièces. La résolution de cet exercice repose essentiellement sur l'utilisation correcte des tableaux associatifs. Si vous savez les gérer correctement et créer les bonnes associations, le code final devrait être assez court.

# Comment faire?

## Etape 1  

En utilisant une hashmap on peut enregistrer pour chaque piece et chaque direction d entree la direction de sortie

```java
Map<Integer,List<String>>dirSuiv  = new HashMap<Integer, List<String>>();

```

### Rappel   
Une Hashmap permet d associer des cles et des valeurs par exemple
```java
 Map<String,String>paysLangue  = new HashMap<String, String>();
```

Et pour ajouter des paires on utiliser la methode ##put##

```java
paysLangue.put("France", "Francais");
```

Maintenant,un peu plus complexe, si l on considere le cas de la Suisse on se rend compte   
que la paire <String, String> est insuffisante, en effet plusieurs langues y sont parlees,   
il faudrait donc une liste.   

```java
 Map<String,List <String>>paysLangues  = new HashMap<String, List<String>>();
```

Dans ce cas pour ajouter une paire il faut decomposer le probleme.   

```java
List<String> languesEnSuisse = new ArrayList<String>();
languesEnSuisse.add("Fr");
languesEnSuisse.add("It");
paysLangues.put("Suisse", languesEnSuisse);
```


Dans le cas du puzzle c est pareil mais en plus long puisqu il y a 14 pieces   

```java
List<String> valSet1 = new ArrayList<String>();
valSet1.add("N");
dirSuiv.put(0, valSet1);


List<String> valSet2 = new ArrayList<String>();
valSet2.add("D");
dirSuiv.put(1, valSet2);


List<String> valSet3 = new ArrayList<String>();
valSet3.add("R");
valSet3.add("L");
dirSuiv.put(2, valSet3);

List<String> valSet4 = new ArrayList<String>();
valSet4.add("D");
dirSuiv.put(3, valSet4);

List<String> valSet5 = new ArrayList<String>();
valSet5.add("D");
valSet5.add("L");
dirSuiv.put(4, valSet5);

List<String> valSet6 = new ArrayList<String>();        
valSet6.add("D");
valSet6.add("R");
dirSuiv.put(5, valSet6);

List<String> valSet7 = new ArrayList<String>();
valSet7.add("R");
valSet7.add("L");
dirSuiv.put(6, valSet7);


List<String> valSet8 = new ArrayList<String>();
valSet8.add("D");
dirSuiv.put(7, valSet8);


List<String> valSet9 = new ArrayList<String>();
valSet9.add("D");
dirSuiv.put(8, valSet9);
        
List<String> valSet10 = new ArrayList<String>();
valSet10.add("D");
dirSuiv.put(9, valSet10);

List<String> valSet11 = new ArrayList<String>();
valSet11.add("L");
dirSuiv.put(10, valSet11);

List<String> valSet12 = new ArrayList<String>();
valSet12.add("R");
dirSuiv.put(11, valSet12);


List<String> valSet13 = new ArrayList<String>();
valSet13.add("D");
dirSuiv.put(12, valSet13);

List<String> valSet14 = new ArrayList<String>();
valSet14.add("D");
dirSuiv.put(13, valSet14);
        
```

## Etape 2 

On utilise une fonction prenant en entree la HashMap cree precedemment ainsi qu une position   
(RIGHT,LEFT,TOP,DOWN) et le numero de la forme du carre actuel(un entier entre 0 et 13). 

Les cas qu il va falloir considerer avec attention sont les cas dans lesquels les carres ont   
plusieurs sorties possibles en fonction de l entree.   
Par exemple le carre de forme 6 est concu ainsi :   
Si on vient de la gauche, alors on va a droite,
si on vient de la droite, alors on va a gauche.   

```java
public static String dirige(Map<Integer,List<String>>dirSuiv, String Pos,int key){
    String c = "D";
    for (Map.Entry<Integer, List<String>> entry : dirSuiv.entrySet()) {
        if ((key == 2 &&  Pos.equals("LEFT")) ||
            (key == 5 &&  Pos.equals("TOP"))||
            (key == 6 &&  Pos.equals("LEFT"))|| 
            (key == 11)
            ) {
                c = "R";
            }
        else if ((key == 2 &&  Pos.equals("RIGHT") ||
            (key == 4 &&  Pos.equals("TOP"))||
            (key == 6 &&  Pos.equals("RIGHT")))||
            (key == 10)
            ) {
                c = "L";
            }
            
    else if ((key == 4 &&  Pos.equals("RIGHT"))||
            (key == 5 &&  Pos.equals("LEFT"))
            ) {
                c = "D";
            }
    

    }
return c;
}


```


## Etape 3

Maintenant c est presque fini, il reste a utiliser correctement la fonction precedente.
Cette derniere renvoyant la direction dans laquelle on doit utiliser, on utilise donc   
un ##switch case## fonctionnant ainsi :   
Dans le cas sortie gauche : decrementer la position sur l axe des abscisses
Dans le cas sortie droite : incrementer la position sur l axe des abscisses
Dans le cas sortie bas    : incrementer la position sur l axe des abscisses


```java
while (true) {
int XI = in.nextInt();
int YI = in.nextInt();
String POS = in.next();

String x = dirige(dirSuiv,POS,LINE[YI][XI]);
switch (x) {
    case "D": YI++; break;
    case "L": XI--; break;
    case "R": XI++; break;
}

System.out.println(XI+" "+YI);

```