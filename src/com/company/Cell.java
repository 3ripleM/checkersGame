package com.company;

public class Cell {

    public Table table ;
    private Position position ;
    private Marble marble ;



    Cell(Table table , Position position ){
        this.table = table ;
        this.position = position ;
    }

    void addMarble(Marble marble){
        this.marble = marble ;
        marble.cell = this ;
    }

    public Boolean isEmpty(){
        if(marble == null){
            return true ;
        }else{
            return false ;
        }
    }

    public Marble getMarble(){
        return this.marble ;
    }

    public void deleteMarble(){
        this.marble = null ;
    }

    public Position getPosition() {
        return position;
    }
}
