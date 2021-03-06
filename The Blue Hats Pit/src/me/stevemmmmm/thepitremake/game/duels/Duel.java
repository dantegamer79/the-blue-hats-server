package me.stevemmmmm.thepitremake.game.duels;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/*
 * Copyright (c) 2020. Created by Stevemmmmm.
 */

public class Duel {
    private final Player playerA;
    private final Player playerB;

    private Vector playerAPos;
    private Vector playerBPos;

    public Duel(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public Duel(Player playerA, Player playerB, Vector playerAPos, Vector playerBPos) {
        this.playerA = playerA;
        this.playerB = playerB;

        this.playerAPos = playerAPos;
        this.playerBPos = playerBPos;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setPlayerAPos(Vector playerAPos) {
        this.playerAPos = playerAPos;
    }

    public void setPlayerBPos(Vector playerBPos) {
        this.playerBPos = playerBPos;
    }

    public Vector getPlayerAPos() {
        return playerAPos;
    }

    public Vector getPlayerBPos() {
        return playerBPos;
    }
}