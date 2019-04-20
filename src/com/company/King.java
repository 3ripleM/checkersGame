package com.company;

import java.util.ArrayList;

public class King extends Marble {

    King(Player player) {
        this.marbleCharacter = (player.turn == 0) ? "♔" : "♚";
        this.player = player;
        setRules();
    }

    @Override
    void setRules() {
        this.rules = new Pair[]{
                new Pair(1, -1),
                new Pair(1, 1),
                new Pair(-1, 1),
                new Pair(-1, -1)
        };
    }

}


