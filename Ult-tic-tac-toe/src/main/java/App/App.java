package App;

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
