package com.company;

import java.util.HashMap;

public class GameManager {

    Table table ;
    private int turn = 0 ;
    private Player[] player = new Player[2] ;


    GameManager(){
        table = new Table(8 , this);
        setPlayerInfo();
        start();
    }

    //@TODO : complete This :)
    boolean isEnded(){
        if(player[turn].availableMoves().size() == 0){
            Helper.print(String.format("\n $s win the game." , player[(turn+1)%2].name));
            return true ;
        }
        return false ;
    }



    private void setPlayerInfo(){
        player[0] = new Player(
                Helper.stringInput("enter player name") ,
                this ,
                0 ,
                "●"
        );
        player[1] = new Player(
                Helper.stringInput("enter player name") ,
                this ,
                1 ,
                "○"
        );
    }


    void start(){
        while (!this.isEnded()){
            MovementType movementType = player[turn].playTurn() ;
            if(!(movementType == MovementType.capture && player[turn].isCaptureMoveAvailable())){
                turn = (turn+1)%2 ;
            }
        }
    }




}


