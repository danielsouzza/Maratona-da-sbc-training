import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatrulheirosRomanos {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        

        while(true){
            int numberOfCity = input.nextInt();
            int numberOfStreet = input.nextInt();
            int cycles = input.nextInt();
            int currentCity = input.nextInt();
            Imperi imperi = new Imperi();

            

            if (numberOfCity == 0 && numberOfStreet == 0 && cycles == 0 && currentCity == 0)
            break;
            
            // Escolher a cidade destino
            for(int i = 0; i < numberOfCity; i++){
                imperi.addCity(new City(i));
            }

            for(int i = 0; i < numberOfStreet; i++){
                int cityA = input.nextInt();
                int cityB = input.nextInt();
                int distance = input.nextInt();
                imperi.addStreet(new Street(imperi.getCity(cityA-1),imperi.getCity(cityB-1), distance));
            }

            City bigInactivity = null;
            City origin = imperi.getCity(currentCity-1);
            City destiny = null;
            Street street = null;
            // Simulação
            while(cycles > 0){

                int instantDowntime = 0;
                //
                for(City city :imperi.citys){
                    if(bigInactivity == null || city.inactivity > bigInactivity.inactivity){
                        bigInactivity = city;
                    }
                }

                for(City city: imperi.citys){
                    if((imperi.hasRelation(origin, city) != null) && city.id == bigInactivity.id){
                        destiny = city;
                        street = imperi.hasRelation(origin, destiny);
                    }
                }

                if(destiny == null){
                    for(City city: imperi.citys){
                        // Verifica a cidade mais proxima com menor indentificador
                        if(imperi.hasRelation(origin, city) != null){
                            destiny = city;
                            bigInactivity = null;
                            break; // para quando ele encontra o mais proximo
                        }
                    }
                    street = imperi.hasRelation(origin, destiny);
                }
                
                int count = 0;
                if(cycles < street.distance) count = cycles;
                else count = street.distance;
                
                for(City city : imperi.citys){
                    for(int i = 0; i < count; i++){
                        city.inactivity++;
                        instantDowntime += city.inactivity;
                    }
                }
                
                if(street.distance <= cycles){
                    instantDowntime -= destiny.inactivity;
                }
                
                cycles -= count;
                destiny.inactivity = 0;
                origin = destiny;
                imperi.inactivity += instantDowntime;
            }

            System.out.println(imperi.inactivity);
        }
    }
}

class Imperi{
    int inactivity;
    List<City> citys;
    List<Street> streets;

    Imperi(){
        this.inactivity = 0;
        this.citys = new ArrayList<>();
        this.streets  = new ArrayList<>();
    }

    
    public Street hasRelation(City a, City b){
        for(Street street : streets) {
            if(street.cityA.id == a.id && street.cityB.id == b.id || 
            street.cityB.id == a.id && street.cityA.id == b.id){
                    return street;
                }
        }
        return null;
    }

    public City getCity(int i){
            return this.citys.get(i);
    }

    public void addStreet(Street street){
            this.streets.add(street);
    }
    
    public void addCity(City city){
            this.citys.add(city);
    }
}

class Street{
    City cityA;
    City cityB;
    int distance;
    Street(City A, City B,int distance){
        this.cityA = A;
        this.cityB = B;
        this.distance = distance;
    }

    public boolean hasRelation(City city){
        return (city.id == cityA.id || city.id == cityB.id) ? true : false;
    }

    public City choiceCity(City city){
        return (city.id == cityA.id) ? cityB : cityA;
    }
}

class City{
    int id;
    int inactivity;

    City(int identifier){
        this.id = identifier;
        this.inactivity = 0;
    }

}
