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
    def multi(myList: List[Long]): Long = {
        myList match {
            case Nil => 1
            case firstElement::reste => firstElement * multi(reste)
        }
    }

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
    /*
    def multiBinaire(myList: List[Long], indice: Int, nb: Int): Long = {
      indice match {
        case 1 => nb match {
          case 0 => 1
          case _ => myList match {
            case Nil => 1
            case elem::reste => elem * multiBinaire(reste, indice-1, nb-1) 
          }
        }
        case _ => multiBinaire(myList.tail, indice-1, nb)
      }
    }
    */
    
    def multiBinaire(myList: List[Long], indice: Int, nb: Int): Long = {
      (indice, myList, nb) match {
        case (_, _, 0) => 1
        case (1, elem::reste, _) => elem * multiBinaire(reste, 1, nb-1)
        case (_, Nil, _) => 1
        case (_, elem::reste, _) => multiBinaire(reste, indice-1, nb)
      }
    }

    /**
     * Ecrire une methode qui renvoie si les nombres d'une liste sont dans une ordre croissant.
     *
     * @param   myList une liste de nombres
     * @return  le plus grand element de la liste `myList`
     * @throws  java.util.IllegalArgumentException si `myList` est une liste vide
     */
    def isGrowing(myList: List[Long]): Boolean = {
      def _isGrowing(myList: List[Long], last: Long) : Boolean = {
        myList match {
          case Nil => true
          case elem::reste if elem >= last => _isGrowing(reste, elem)
          case elem::reste if elem < last => false
        }
      }
      if (myList.isEmpty) {
        true
      } else {
        _isGrowing(myList, myList.head)
      }
    }

    /**
     * Ecrire une methode qui renverse une liste.
     *
     * Sans utiliser la methode revert de la classe List
     *
     * @param   myList une liste de nombres
     * @return  liste avec l'ordre des elements inverses
     */
    def renverse(myList: List[Long]): List[Long] = {
      myList match {
        case Nil => throw new IllegalArgumentException("Liste vide")
        case elem::Nil => elem::Nil
        case _ => myList.last::renverse(myList.init)
      }
    }

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
    def min(myList: List[Long]): Long = {
      def smaller(nb1: Long, nb2: Long) : Long = {
        if (nb1 <= nb2) {
          nb1
        } else {
          nb2
        }
      }
      myList match {
        case Nil => throw new IllegalArgumentException("Liste vide")
        case elem::Nil => elem 
        case elem::reste => smaller(elem, min(reste))
      }
    }

    /**
     * Ecrire une methode qui renvoie la fusion de 2 listes de nombres sans redondance.
     *
     * Sans utiliser les methodes distinct et removeDuplicates de la classe List
     *
     * @param   listA une liste de nombres
     * @param   listB une liste de nombres
     * @return  funsion des 2 listes
     */
    /*
    def fusion(listA: List[Long], listB: List[Long]): List[Long] = {
      def contains(needle: Long, myList: List[Long]): Boolean = {
        (needle, myList) match {
          case (needle, Nil) => false
          case (needle, elem::reste) if elem == needle => true
          case (needle, elem::reste) if elem != needle => contains(needle, reste)
        }
      }
      (listA, listB) match {
        case (Nil, Nil) => Nil
        case (Nil,_) => listB
        case (_, Nil) => listA
        case (elemA::resteA, _) if !contains(elemA, listB) => elemA::fusion(resteA, listB)
        case (elemA::resteA, _) if contains(elemA, listB) => fusion(resteA, listB)
      }
    }
    */
    
    def fusion(listA: List[Long], listB: List[Long]): List[Long] = {
      def count(needle: Long, myList: List[Long]): Long = {
        (needle, myList) match {
          case (needle, Nil) => 0
          case (needle, elem::reste) if elem == needle => 1 + count(needle, reste)
          case (needle, elem::reste) if elem != needle => count(needle, reste)
        }
      }
      def removeDup(myList: List[Long]) : List[Long] = {
        myList match {
          case Nil => Nil
          case elem::Nil if count(elem, myList) > 1 => Nil
          case elem::Nil if count(elem, myList) == 1 => elem::Nil
          case elem::reste if count(elem, myList) > 1 => removeDup(reste)
          case elem::reste if count(elem, myList) == 1 => elem::removeDup(reste)
        }
      }
      removeDup(listA:::listB)
    }

    /**
     * Ecrire une methode qui aplatit une liste. List(1, List(2, 3), 4) donnera List(1, 2, 3, 4 )
     * Any est le type parent de tout les types et tout les objets
     *
     * @param   list une liste de liste
     * @return  la liste aplatit
     */
    def flatten(list: List[Any]): List[Any] = {
      list match {
        case (elem:List[_])::reste => flatten(elem):::flatten(reste)
        case elem::reste => elem::flatten(reste)
        case _ => Nil
      }
    }

    /**
     * Ecrire une methode qui renvoie l intersection de deux listes de nombres sans redondance.
     *
     * Sans utiliser la methode intersect de la classe List
     *
     * @param   listA une liste de nombres
     * @param   listB une liste de nombres
     * @return  funsion des 2 listes
     */
    def intersection(listA: List[Long], listB: List[Long]): List[Long] = {
      (listA, listB) match {
        case (Nil, Nil) | (Nil, _) | (_, Nil) => Nil
        case (elemA::resteA, _) if listB.contains(elemA) => elemA::intersection(resteA, listB)
        case (elemA::resteA, _) if !listB.contains(elemA) => intersection(resteA, listB)
      }
    }
}
