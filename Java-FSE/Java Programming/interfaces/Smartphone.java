public class Smartphone implements MusicPlayer, Camera{
    @Override
    public void play(){
        System.out.println("Playing the music");
    }

    @Override
    public void pause(){
        System.out.println("Pausing the music.");
    }

    @Override
    public void next(){
        System.out.println("Going to next song.");
    }

    @Override
    public void prev(){
        System.out.println("Returning to previous song.");
    }

    @Override
    public void click(){
        System.out.println("Clicking the picture.");
    }

    @Override
    public void record(){
        System.out.println("Recording video.");
    }
}
