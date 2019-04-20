package com.company;

import java.util.ArrayList;

//" ● ○" ♔♚
abstract class Marble {
    Player player ;
    Cell cell ;
    String marbleCharacter ;
    abstract void setRules() ;
    Pair<Integer , Integer>[] rules ;

    boolean isMen(){
        return this.getClass() == Men.class ;
    }

    boolean isKing(){
        return this.getClass() == King.class ;
    }



    void moveToCell(Cell cell){
        this.cell.deleteMarble();
        this.cell = cell ;
        cell.addMarble(this);

    }

     void delete(){
        cell.deleteMarble();
        player.deleteMarble(this);
     }

    ArrayList<Movement> availableMoves() {
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Position currentPosition = this.cell.getPosition() ;


        for(int i = 0; i < rules.length ; i++ ){
            Cell cell  = this.cell.table.getCell(new Position(
                    currentPosition.x+ rules[i].first,
                    currentPosition.y+rules[i].second
            )) ;

            Cell cell2 = this.cell.table.getCell(new Position(
                    currentPosition.x+ (rules[i].first * 2) ,
                    currentPosition.y+(rules[i].second * 2)
            )) ;

            if(cell != null){
                if(cell.isEmpty()){
                    movements.add(new Movement(this.cell , cell , MovementType.normal)) ;

                }else if(cell2 != null && cell2.isEmpty() && cell.getMarble().player.turn != this.player.turn){
                    movements.add(new Movement(this.cell , cell2 , MovementType.capture)) ;
                }
            }
        }

        return movements ;

    }

}
