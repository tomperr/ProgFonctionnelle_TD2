package example

import common._

object listsFun {
    /**
     * Ecrire une methode qui permet de calculer la multiplication de tous les elements de la liste `myList`,
     * Sans utiliser une boucle `for` ou `while`.
     *
     * il y a plusieurs techniques qui peuvent etre utilisees  pour mettre en oeuvre cette methode
     *
     * Pour cet exemple, vous devez utiliser les methodes  suivantes
     *
     *   - myList.isEmpty : Retourne true si la liste `myList` est vide, false sinon
     *   - myList.head    : Retourne le premier element de la liste `myList`. Si la liste est vide une exception est levée
     *   - myList.tail    : Retourne la queue de la liste `myList`, i.e. la liste `myList` sans son element de tete
     *
     * @param   myList une liste de nombres
     * @return  la multiplicaton de tous les éléments de la liste `myList`
     */
    def multi(myList: List[Long]): Long = ???

    /**
     * Ecrire une methode qui permet de calculer la multiplication de n entiers dans la liste `myList`, ou l’on
     * commence à multiplier a partir de l’indice i
     *
     * Sans utiliser une boucle `for` ou `while`.
     *
     * @param   myList une liste de nombres
     * @param   indice on multiplie a partir de cet indice
     * @param   nb entier de la liste a multiplier
     * @return  la multiplication des nb éléments des la liste `myList` a partir de indice
     */
    def multiBinaire(myList: List[Long], indice: Int, nb: Int): Long = ???

    /**
     * Ecrire une methode qui renvoie si les nombres d'une liste sont dans une ordre croissant.
     *
     * @param   myList une liste de nombres
     * @return  le plus grand element de la liste `myList`
     * @throws  java.util.IllegalArgumentException si `myList` est une liste vide
     */
    def isGrowing(myList: List[Long]): Boolean = ???

    /**
     * Ecrire une methode qui renverse une liste.
     *
     * Sans utiliser la methode revert de la classe List
     *
     * @param   myList une liste de nombres
     * @return  liste avec l'ordre des elements inverses
     */
    def renverse(myList: List[Long]): List[Long] = ???

    /**
     * Ecrire une methode qui renvoie le plus petit element contenu dans une liste de nombres.
     *
     * Sans utiliser la methode sort de la classe List
     *
     * Si la liste `myList` est vide, elle leve un `java.util.IllegalArgumentException`.
     * On peut utiliser les memes methodes que ci-dessus.
     *
     * Astuce: Encore une fois, penser à une solution recursive au lieu d'utiliser des constructions en boucle.
     *         Vous devez définir une methode auxiliaire qui a un parametre representant la valeur min actuel.
     *
     * @param   myList une liste de nombres
     * @return  le plus grand element de la liste `myList`
     * @throws  java.util.IllegalArgumentException si `myList` est une liste vide
     */
    def min(myList: List[Long]): Long = ???

    /**
     * Ecrire une methode qui renvoie la fusion de 2 listes de nombres sans redondance.
     *
     * Sans utiliser les methodes distinct et removeDuplicates de la classe List
     *
     * @param   listA une liste de nombres
     * @param   listB une liste de nombres
     * @return  funsion des 2 listes
     */
    def fusion(listA: List[Long], listB: List[Long]): List[Long] = ???

    /**
     * Ecrire une methode qui aplatit une liste. List(1, List(2, 3), 4) donnera List(1, 2, 3, 4 )
     * Any est le type parent de tout les types et tout les objets
     *
     * @param   list une liste de liste
     * @return  la liste aplatit
     */
    def flatten(list: List[Any]): List[Any] = ???

    /**
     * Ecrire une methode qui renvoie l intersection de deux listes de nombres sans redondance.
     *
     * Sans utiliser la methode intersect de la classe List
     *
     * @param   listA une liste de nombres
     * @param   listB une liste de nombres
     * @return  funsion des 2 listes
     */
    def intersection(listA: List[Long], listB: List[Long]): List[Long] = ???
}
