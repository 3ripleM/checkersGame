package com.company;

import com.sun.jdi.connect.Connector;

public class Position {
    public int x ;
    public int y ;

    Position(int x , int y){
        this.x = x ;
        this.y = y ;
    }

    Boolean isValid(int size ){
        return (this.x < size && this.y <size && this.x >= 0 && this.y >= 0) ;
    }

}
