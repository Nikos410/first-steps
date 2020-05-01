import GLOOP.*;
class Untergrund{
    GLQuader platte;
    
    Untergrund(){
        platte  = new GLQuader(0,0,-10, 600,20,600);  
        platte.setzeTextur("Holzboden.jpg");
    }
}
