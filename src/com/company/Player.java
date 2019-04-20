package com.company;

import java.util.ArrayList;

public class Player {

    public String name ;
    public int turn ;
    private GameManager game ;
    private Marble[] marbles ;
    String marbleCharacter ;
    int marblesCount ;

    Player(String name ,GameManager game , int turn ,String c ){
        this.name = name ;
        this.game = game ;
        this.turn = turn ;
        this.marbleCharacter = c ;
        this.marblesCount = ((game.table.size -1 )*(game.table.size -1 ) - 1)/4 ;
        this.marbles = new Marble[marblesCount] ;
        System.out.println(marblesCount);
        setFirstMens();
    }

    int marbleIndex(Marble marble){
        for(int i = 0 ; i < this.marbles.length ; i++ ){
            if (this.marbles[i] == marble) {
                return i ;
            }
        }
        return -1 ;
    }
    void setFirstMens(){
        int trn = this.turn ;
        int sz = game.table.size ;
        int st = (trn == 0) ? 0 : sz/2 + 1 ;
        int end = (trn == 0) ? sz/2 - 2 : sz-1 ;

        System.out.println(st);
        System.out.println(end);

        int k = 0 ;

        for(int i =st ; i <= end ; i++ ){
            for(int j =0 ; j < sz ; j++ ){
                if( i%2 == j%2 ){
                    marbles[k] = new Men(this) ;
                    this.game.table.addMarbleToCell(
                            this.game.table.getCell(new Position(j,i)),
                            marbles[k]
                    );
                    k++ ;
                }
            }
        }

        // j = 0 | i = 4


        game.table.print();
    }

    void menToKing(Men men){
        King king = men.toKing() ;
        this.marbles[marbleIndex(men)] = king ;
        Cell cell = men.cell ;
        cell.deleteMarble();
        cell.addMarble(king);
    }

    int lastRow(){
        return (turn == 1)? 0 : game.table.size - 1 ;
    }

    boolean isCaptureMoveAvailable(){
        ArrayList<Movement> captureMoves = new ArrayList<Movement>() ;
        for (Marble marble:marbles) {
            if(marble != null){
                marble.availableMoves().forEach(movement -> {
                    captureMoves.add(movement) ;
                });
            }
        }
        return !(captureMoves.isEmpty()) ;
    }


    void deleteMarble(Marble marble){
        this.marbles[marbleIndex(marble)] = null ;
    }

    ArrayList<Movement> availableMoves(){

        ArrayList<Movement> allMoves = new ArrayList<Movement>() ;
        for (Marble marble:marbles) {
            if(marble != null){
                allMoves.addAll(marble.availableMoves()) ;
            }
        }

        Boolean captueAvailable ;
        ArrayList<Movement> captureMoves = new ArrayList<Movement>() ;

        allMoves.forEach((movement) -> {
            if(movement.type == MovementType.capture){
                captureMoves.add(movement) ;
            }
        });

        if(captureMoves.isEmpty()){
            return allMoves ;
        }else {
            return captureMoves ;
        }

    }


    MovementType playTurn(){
        Helper.print(String.format("%s's turn.\n" , this.name));
        Movement[] turnMoves =  availableMoves().toArray(new Movement[availableMoves().size()]) ;
        for(int i = 0 ; i < turnMoves.length ; i++ ){
            turnMoves[i].print(i); ;
        }
        int id = Helper.intInput("Enter ID of your move.") ;
        Movement selectedMove = turnMoves[id] ;

        selectedMove.run();

        this.game.table.print();
        return selectedMove.type ;
    }



}
