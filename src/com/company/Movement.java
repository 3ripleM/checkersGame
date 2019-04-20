package com.company;

public class Movement {
    public Cell start ;
    public Cell end ;
    public MovementType type ;

    Movement(Cell start , Cell end , MovementType type){
        this.start = start ;
        this.end = end ;
        this.type = type ;
    }

    Cell getCaptureCell(){
        if(this.type == MovementType.capture){
            int captureCellx = (this.start.getPosition().x + this.end.getPosition().x) / 2 ;
            int captureCelly = (this.start.getPosition().y + this.end.getPosition().y) / 2 ;
            return start.table.getCell(new Position(captureCellx , captureCelly)) ;
        }else{
            return null ;
        }
    }

    void run(){
        this.start.getMarble().moveToCell(this.end);
        if(this.type == MovementType.capture){
              getCaptureCell().getMarble().delete();
        }
        if(this.end.getPosition().y == this.end.getMarble().player.lastRow() && this.end.getMarble().isMen()){
            this.end.getMarble().player.menToKing((Men)this.end.getMarble());
        }
    }

    void print(int x){

        String id = String.format("ID:%d" , x) ;
        String st = String.format("From: x:%d y:%d" , start.getPosition().x , start.getPosition().y ) ;
        String ed = String.format("To: x:%d y:%d" , end.getPosition().x , end.getPosition().y ) ;
        String tp = String.format("Type : %s" , this.type ) ;
        System.out.format("%-15s%-15s%-15s%-15s\n", id , st , ed , tp);
    }
}
