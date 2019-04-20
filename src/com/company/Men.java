package com.company;

import java.util.ArrayList;

public class Men extends Marble {

    Men(Player player){
        this.marbleCharacter = (player.turn == 0) ? "○" : "●" ;
        this.player = player ;
        setRules();
    }

    King toKing(){
        return new King(player) ;
    }


    @Override
    void setRules() {
        this.rules  = (player.turn == 1) ?
                new Pair[]{new Pair( 1,-1), new Pair(-1,-1)} :
                new Pair[]{new Pair( 1,1), new Pair(-1,1)} ;
    }


}
