class Car{
    String model;
    boolean isEngineOn;

    Car(String model){
        this.model = model;
        this.isEngineOn = false;
    }

    //* This is a member inner class that is associated with the instance of outer class.
    class Engine{
        void start(){
            if(!isEngineOn){
                isEngineOn = true;
                System.out.println("Turning on the engine.");
            }else{
                System.out.println("Engine is already turned on.");
            }
        }

        void stop(){
            if(isEngineOn){
                isEngineOn = false;
                System.out.println("Turning off the engine.");
            }else{
                System.out.println("The engine is already turned off.");
            }
        }
    }
}