package com.company;


import java.util.LinkedList;

public class LinkedList2<E> {
    Node<E> first;
    Node<E> last;
    int size = 0;
    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    /*
    Need methods:
        add,
        get,
        size,
        remove,
        clear
        set
    */
    public boolean add(E element){
        size++;
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if(l == null){
            first = newNode;
        }
        else{
            l.next = newNode;
        }
        return true;
    }
    public E get(int index) throws SizeException{
        Node x;
        int i;
        if(index >= size){
            throw new SizeException("Index:  "+ index +" , Size: " + size);
        }
        if (index < size >> 1) {
            x = first;

            for(i = 0; i < index; ++i) {
                x = x.next;
            }

        } else {
            x = last;

            for (i = this.size - 1; i > index; --i) {
                x = x.prev;
            }
        }
        return(E) x.item;
    }
    public int size(){
        return size;
    }
    public E set(int index, E element) throws SizeException {
        Node x;
        int i;
        if(index >= size){
            throw new SizeException("Index:  "+ index +" , Size: " + size);
        }
        if (index < size >> 1) {
            x = first;

            for(i = 0; i < index; ++i) {
                x = x.next;
            }

        } else {
            x = last;

            for (i = this.size - 1; i > index; --i) {
                x = x.prev;
            }
        }
        E oldVal =(E) x.item;
        x.item = element;
        return oldVal;
    }
    public E remove(int index) throws SizeException{
        Node x;
        int i;
        if(index >= size){
            throw new SizeException("Index:  "+ index +" , Size: " + size);
        }
        if (index < size >> 1) {
            x = first;

            for(i = 0; i < index; ++i) {
                x = x.next;
            }

        } else {
            x = last;

            for (i = this.size - 1; i > index; --i) {
                x = x.prev;
            }
        }
        size--;
        E oldVal =(E) x.item;
        if(x.prev == null){
            first = x.next;
            x.next.prev = null;
        }
        else if(x.next == null){
            last = x.prev;
            x.prev.next = null;
        }
        else {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
        return oldVal;
    }
    public void clear(){
        Node next;
        for(Node x = this.first; x != null; x = next) {
            next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
        }

        first = last = null;
        size = 0;
    }


}
