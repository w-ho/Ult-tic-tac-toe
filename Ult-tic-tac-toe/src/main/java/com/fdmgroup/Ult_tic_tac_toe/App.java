package com.fdmgroup.Ult_tic_tac_toe;

import game.BigGame;

public class App 
{
    public static void main( String[] args )
    {
        BigGame game =  new BigGame ();
        game.intro();
        game.play();
    }
       
}
