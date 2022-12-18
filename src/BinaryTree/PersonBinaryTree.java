package BinaryTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonBinaryTree {
  private Element<Person> root;

  public PersonBinaryTree() {
    this.root = null;
  }

  public Element<Person> getRoot() {
    return this.root;
  }

  public void add(Person value) {
    Element<Person> newElement = new Element<Person>(value.getName(), value);

    if (this.root == null) {
      this.root = newElement;
    } else {

      Element<Person> current = this.root;

      while (true) {
        // New element is Less than current (alphabetic)
        List list = Arrays.asList(newElement.getKey(), current.getKey());
        Collections.sort(list);

        if (list.get(0).equals(newElement.getKey())) {
          if (current.getLeft() != null) {
            current = current.getLeft();
          } else {
            current.setLeft(newElement);
            break;
          }

          // New element is Bigger than current
        } else {
          if (current.getRight() != null) {
            current = current.getRight();
          } else {
            current.setRight(newElement);
            break;

          }
        }
      }
    }
  }

  public void inOrder(Element<Person> current) {
    if (current != null) {
      inOrder(current.getLeft());
      System.out.println(current.toString());
      inOrder(current.getRight());
    }
  }

  public void preOrder(Element<Person> current) {
    if (current != null) {
      System.out.println(current.getValue());
      preOrder(current.getLeft());
      preOrder(current.getRight());
    }
  }

  public void posOrder(Element<Person> current) {
    if (current != null) {
      posOrder(current.getLeft());
      posOrder(current.getRight());
      System.out.println(current.getValue());
    }
  }

  public boolean remove(String valor) {
    // buscar o elemento na árvore
    Element<Person> atual = this.root;
    Element<Person> paiAtual = null;
    while (atual != null) {
      if (atual.getKey().equals(valor)) {
        break;
      } else if (valor.compareTo(atual.getKey()) == -1) { // valor procurado é menor que o atual
        paiAtual = atual;
        atual = atual.getLeft();
      } else {
        paiAtual = atual;
        atual = atual.getRight();
      }
    }
    // verifica se existe o elemento
    if (atual != null) {

      // elemento tem 2 filhos ou elemento tem somente filho à direita
      if (atual.getRight() != null) {

        Element<Person> substituto = atual.getRight();
        Element<Person> paiSubstituto = atual;
        while (substituto.getLeft() != null) {
          paiSubstituto = substituto;
          substituto = substituto.getLeft();
        }
        substituto.setLeft(atual.getLeft());
        if (paiAtual != null) {
          if (atual.getKey().compareTo(paiAtual.getKey()) == -1) { // atual < paiAtual
            paiAtual.setLeft(substituto);
          } else {
            paiAtual.setRight(substituto);
          }
        } else { // se não tem paiAtual, então é a root
          this.root = substituto;
          paiSubstituto.setLeft(null);
          this.root.setRight(paiSubstituto);
          this.root.setLeft(atual.getLeft());
        }

        // removeu o elemento da árvore
        if (substituto.getKey().compareTo(paiSubstituto.getKey()) == -1) { // substituto < paiSubstituto
          paiSubstituto.setLeft(null);
        } else {
          paiSubstituto.setRight(null);
        }

      } else if (atual.getLeft() != null) { // tem filho só à esquerda
        Element<Person> substituto = atual.getLeft();
        Element<Person> paiSubstituto = atual;
        while (substituto.getRight() != null) {
          paiSubstituto = substituto;
          substituto = substituto.getRight();
        }
        if (paiAtual != null) {
          if (atual.getKey().compareTo(paiAtual.getKey()) == -1) { // atual < paiAtual
            paiAtual.setLeft(substituto);
          } else {
            paiAtual.setRight(substituto);
          }
        } else { // se for a root
          this.root = substituto;
        }

        // removeu o elemento da árvore
        if (substituto.getKey().compareTo(paiSubstituto.getKey()) == -1) { // substituto < paiSubstituto
          paiSubstituto.setLeft(null);
        } else {
          paiSubstituto.setRight(null);
        }
      } else { // não tem filho
        if (paiAtual != null) {
          if (atual.getKey().compareTo(paiAtual.getKey()) == -1) { // atual < paiAtual
            paiAtual.setLeft(null);
          } else {
            paiAtual.setRight(null);
          }
        } else { // é a root
          this.root = null;
        }
      }

      return true;
    } else {
      return false;
    }
  }

  public Element<Person> findElement(String value) {
    Element<Person> current = this.root;

    while (current != null) {
      if (current.getKey().equals(value)) {
        System.out.println(current.toString());
        return current;

      } else if (value.compareTo(current.getKey()) == -1) { // valor menor que o atual
        current = current.getLeft();
      } else {
        current = current.getRight();
      }
    }

    return null;
  }
}
