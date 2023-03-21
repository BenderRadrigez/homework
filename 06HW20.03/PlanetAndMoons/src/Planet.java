public class Planet {
    public int numberOfMoons;
    int numberOfPossibleMoons;
    public String name;

    Planet(){
        System.out.println("это якобы пустой конструктор.)");
        nameAndMoonsForPlanet();
    }

     Planet(int numberOfMoons){
        this.numberOfMoons = numberOfMoons;
         System.out.println("этот конструктор выдает только колличество лун: " + this.numberOfMoons);
         nameAndMoonsForPlanet();
    }

    Planet(String name) {
        this.name = name;
        System.out.println("этот конструктор выдает только имя.\n" +"Я - планета " + this.name);
        nameAndMoonsForPlanet();
    }

    Planet(String name, int numberOfMoons){
        this.name = name;
        this.numberOfMoons = numberOfMoons;
        System.out.println("Я - планета " + this.name + ". У меня " + numberOfMoons + " лун.");
        nameAndMoonsForPlanet();
    }

    Planet(String name, int numberOfOfficialMoons, int numberOfUnofficialMoons){
        this.name = name;
        numberOfMoons = numberOfOfficialMoons;
        numberOfPossibleMoons = numberOfUnofficialMoons;
        System.out.println("Я - планета " + this.name + ". У меня " + numberOfMoons + " подтвержденных и " + numberOfPossibleMoons + " неподтвержденных лун.");
        nameAndMoonsForPlanet();
    }

    void nameAndMoonsForPlanet(){
        System.out.println("имя - " + name);
        System.out.println("луны - " + (numberOfMoons + numberOfPossibleMoons) + "\n");
    }


}
