package com.zts.marathoner.executor;

public class Tuple<E,F> {

    E first;
    F last;

    Tuple(E first, F last){
        this.first = first;
        this.last = last;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public F getLast() {
        return last;
    }

    public void setLast(F last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
