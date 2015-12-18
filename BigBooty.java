import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BigBooty {

    private GUI gui;
    // Constructor

    public BigBooty() {
       

    	// Rooms
        Room world = new Room("World", null, null, new ImageIcon("Images/planet.jpg"));
        
        Room island = new Room("Island","What has a foot but no legs?", "snail", new ImageIcon("Images/Island.jpg"));
            Room volcano = new Room("Volcano","If I drink, I die. If I eat, I am fine. What am I?", "fire", new ImageIcon("Images/volcano.jpg"));
                Room caldera = new Room("Caldera", "What has one eye but cannot see?","needle" ,new ImageIcon("Images/caldera.jpg"));
            Room jungle = new Room("Jungle","Before I grow I'm small. When I'm old I grow tall. When I die I give a mighty fall. What am I?","tree" ,new ImageIcon("Images/jungle.jpg"));
                Room templeOfDoom = new Room("Temple of Doom", "What fastens two people yet touches only one?","Wedding Ring", new ImageIcon("Images/temple.jpg"));
            Room beach = new Room("Beach", "Some call me a Timer, others say when they look at me it reminds (them) of the beach, well I simply think...Time I keep... ", "Hourglass", new ImageIcon("Images/beaches.jpg"));
                Room seaCave = new Room("Seacave","What goes into the water black and comes out red? ","lobster", new ImageIcon("Images/seacave.jpg"));
              
        Room desert = new Room("Desert","What goes around the house and in the house but never touches the house?", "sun", new ImageIcon("Images/desert 2.jpg"));
            Room canyon = new Room("Canyon","I bind it and it walks. I loose it and it stops.","sandal", new ImageIcon("Images/canyon.jpg"));
                Room ruins = new Room("Ruins","I Am The Only Place Where You Will Find Today Before Yesterday.What am I?", "Dictionary", new ImageIcon("Images/ruins.jpg"));
            Room dunes = new Room("Dunes", "What holds water yet is full of holes?" ,"sponge", new ImageIcon("Images/desert.jpeg"));
            Room oasis = new Room("Oasis","What comes down but never goes up?", "rain", new ImageIcon("Images/oasis.jpg"));
          
        Room castle = new Room("Castle", "I am a window to a whole different world and this world can be changed at a move of a finger. But there is one problem you can't enter into my world. What am I? ", "TV",new ImageIcon("Images/Castle-Franconville.jpg"));
            Room graveYard = new Room("Graveyard", "The man who invented it doesn't want it. The man who bought it doesn't need it. The man who needs it doesn't know it. What is it? ", "coffin" ,new ImageIcon("Images/graveyard.jpg"));
                Room tomb = new Room("Tomb", "You're in the tomb with only one match, a lump of coal, a stove, and a kerosene lamp. You have the option of lighting one. Which do you light first?","The match",new ImageIcon("Images/tomb.jpg"));
            Room dungeon = new Room("Dungeon","Poke your fingers in my eyes and I will open wide my jaws. Linen cloth, quills, or paper, my greedy lust devours them all", "scissors", new ImageIcon("Images/dungeon.jpg"));
                Room tortureChamber = new Room("Torture Chamber","Take off my skin - I won't cry, but you will! What am I? ","onion", new ImageIcon("Images/torturechamber.jpg"));
            Room throneRoom = new Room("Throne room","What invention lets you look right through a wall?", "window",new ImageIcon("Images/throneroom.jpg"));
          
        Room city = new Room("City","What goes up when rain comes down?", "Umbrella", new ImageIcon("Images/portland_night_river.jpg"));
            Room wallStreet = new Room("Wall Street", "If I have it, I don't share it. If I share it, I don't have it. What is it?" ,"secret",new ImageIcon("Images/wall street.jpg"));
                Room bank = new Room("Bank", "What is put on a table, cut, but never eaten? ","deck of cards",new ImageIcon("Images/bank.jpg"));
            Room projects = new Room("Projects", "Poor people have it. Rich people need it. I you eat it you die. What is it?", "Nothing", new ImageIcon("Images/ghetto.jpg"));
                Room stripClub = new Room("Strip Club","Can you find a 10 letter word in English language which can be typed using only the 1st rows of the computer keyboard ? ","typewriter",new ImageIcon("Images/strip-club-stage.jpg"));
            Room barbie = new Room("Barbie room", "There was a green house. Inside the green house there was a white house. Inside the white house there was a red house. Inside the red house there were lots of babies. What is it? ","watermelon",new ImageIcon("Images/barbie.jpg"));

            // World exits and items
            Exit worldNorth = new Exit("north", island);
            Exit worldEast = new Exit("east", desert);
            Exit worldWest = new Exit("west", city);
            Exit worldSouth = new Exit("south", castle);
            world.addExit(worldNorth);
            world.addExit(worldEast);
            world.addExit(worldSouth);
            world.addExit(worldWest);

            // Island exits and items
            Exit islandNorth = new Exit("north", beach);
            Exit islandSouth = new Exit("south", jungle);
            Exit islandEast = new Exit("east", volcano);
            island.addExit(islandNorth);
            island.addExit(islandSouth);
            island.addExit(islandEast);
          
            Item snail = new Item("snail");
            Item torch = new Item("torch");
            Item pogostick = new Item("pogostick");
            island.addItem(snail);
            island.addItem(torch);
            island.addItem(pogostick);
          
            //beach exits and items
            Exit beachNorth = new Exit("north", seaCave);
            Exit beachreturn = new Exit("south", island);
            beach.addExit(beachNorth);
            beach.addExit(beachreturn);
          
            Item hourglass = new Item("hourglass");
            Item sandDollar = new Item("sanddollar");
            Item mermaid = new Item("mermaid");
            beach.addItem(hourglass);
            beach.addItem(sandDollar);
            beach.addItem(mermaid);
          
            //sea cave exits and items
            Exit seaCaveReturn = new Exit("south", beach);
            seaCave.addExit(seaCaveReturn);
          
            Item lobster = new Item("lobster");
            Item oil = new Item("oil");
            Item treasureChest = new Item("treasure-chest");
            seaCave.addItem(lobster);
            seaCave.addItem(oil);
            seaCave.addItem(treasureChest);
            //jungle exits and items
            Exit jungleWest = new Exit("west", templeOfDoom);
            Exit jungleReturn = new Exit("north", island);
            jungle.addExit(jungleWest);
            jungle.addExit(jungleReturn);
          
            Item tree = new Item("tree");
            Item whip = new Item("whip");
            Item wall = new Item("wall");
            jungle.addItem(tree);
            jungle.addItem(whip);
            jungle.addItem(wall);
          
            //temple of doom exits and items
            Exit templeofdoomReturn = new Exit("east", jungle);
            templeOfDoom.addExit(templeofdoomReturn);
          
            Item weddingRing = new Item("wedding-ring");
            Item rope = new Item("rope");
            Item seatBelt = new Item("seat belt");
            templeOfDoom.addItem(weddingRing);
            templeOfDoom.addItem(rope);
            templeOfDoom.addItem(seatBelt);
          
            //volcano exits and items
            Exit volcanoEast = new Exit("east", caldera);
            Exit volcanoReturn = new Exit("west", island);
            volcano.addExit(volcanoEast);
            volcano.addExit(volcanoReturn);
          
            Item fire = new Item("fire");
            Item rocks = new Item("rocks");
            Item acid = new Item("acid");
            volcano.addItem(fire);
            volcano.addItem(rocks);
            volcano.addItem(acid);
          
            //Caldera exits and items
            Exit calderaReturn = new Exit("west", volcano);
            caldera.addExit(calderaReturn);

            Item needle = new Item("needle");
            Item fireProofSuit = new Item("fireproof suit");
            Item cyclobs = new Item("cyclobs");
            caldera.addItem(needle);
            caldera.addItem(fireProofSuit);
            caldera.addItem(cyclobs);
          
            // Desert exits and items
            Exit desertWest = new Exit("west", canyon);
            Exit desertNorth = new Exit("north", dunes);
            Exit desertSouth = new Exit("south", oasis);
            desert.addExit(desertWest);
            desert.addExit(desertNorth);
            desert.addExit(desertSouth);
          
            Item sun = new Item("sun");
            Item rainbow = new Item("rainbow");
            Item camel = new Item("camel");
            desert.addItem(sun);
            desert.addItem(rainbow);
            desert.addItem(camel);
          
            //canyon exits and items
            Exit canyonSouth = new Exit("west", ruins);
            Exit canyonReturn = new Exit("east", desert);
            canyon.addExit(canyonReturn);
            canyon.addExit(canyonSouth);
          
            Item sandal = new Item("sandal");
            Item canoe = new Item("canoe");
            Item water = new Item("water");
            canyon.addItem(sandal);
            canyon.addItem(canoe);
            canyon.addItem(water);
          
            //Dunes exits and items
            Exit dunesReturn = new Exit("south", desert);
            dunes.addExit(dunesReturn);
          
            Item sponge = new Item("sponge");
            Item mouth = new Item("mouth");
            Item bucket = new Item("bucket");
            dunes.addItem(sponge);
            dunes.addItem(mouth);
            dunes.addItem(bucket);
          
            //Oasis exits and items
            Exit oasisReturn = new Exit("north", desert);
            oasis.addExit(oasisReturn);
          
            Item rain = new Item("rain");
            Item precipitation = new Item("precipitation");
            Item plant = new Item("plant");
            oasis.addItem(rain);
            oasis.addItem(precipitation);
            oasis.addItem(plant);
          
            //Ruins exits and items
            Exit ruinsReturn = new Exit("east", canyon);
            ruins.addExit(ruinsReturn);
          
            Item dictionary = new Item("dictionary");
            Item cavePaints = new Item("cave-panintings");
            Item fortuneTeller= new Item("fortune teller");
            ruins.addItem(dictionary);
            ruins.addItem(cavePaints);
            ruins.addItem(fortuneTeller);

            //Castle exits and items
            Exit castleNorth = new Exit("north", graveYard);
            Exit castleSouth = new Exit("south", dungeon);
            Exit castleWest = new Exit("east", throneRoom);
            castle.addExit(castleNorth);
            castle.addExit(castleSouth);
            castle.addExit(castleWest);
          
            Item tv = new Item("tv");
            Item sword = new Item("sword");
            Item narnia = new Item("narnia");
            castle.addItem(tv);
            castle.addItem(sword);
            castle.addItem(narnia);
          
            //grave-yard exits and items
            Exit graveYardWest = new Exit("west", tomb);
            Exit graveYardReturn = new Exit("south", castle);
            graveYard.addExit(graveYardWest);
            graveYard.addExit(graveYardReturn);
          
            Item coffin = new Item("coffin");
            Item tombStone = new Item("tombstone");
            Item cross = new Item("cross");
            graveYard.addItem(coffin);
            graveYard.addItem(tombStone);
            graveYard.addItem(cross);
          
            //Tomb
            Exit tombReturn = new Exit("east", graveYard);
            tomb.addExit(tombReturn);
          
            Item match = new Item("match");
            Item coal = new Item("coal");
            Item lamp = new Item("lamp");
            tomb.addItem(match);
            tomb.addItem(coal);
            tomb.addItem(lamp);
          
            //dungeon exits and items
            Exit dungeonEast = new Exit("east", tortureChamber);
            Exit dungeonReturn = new Exit("north", castle);
            dungeon.addExit(dungeonEast);
            dungeon.addExit(dungeonReturn);
          
            Item scissors = new Item("scissors");
            Item axe = new Item("axe");
            Item wheel = new Item("wheel");
            dungeon.addItem(scissors);
            dungeon.addItem(axe);
            dungeon.addItem(wheel);
          
            //torture chamber
            Exit torturechamberReturn = new Exit("west", dungeon);
            tortureChamber.addExit(torturechamberReturn);
          
            Item onion = new Item("onion");
            Item human = new Item("human");
            Item snake = new Item("snake");
            tortureChamber.addItem(onion);
            tortureChamber.addItem(human);
            tortureChamber.addItem(snake);
          
          
            //ThroneRoom
            Exit throneroomReturn = new Exit("west", castle);
            throneRoom.addExit(throneroomReturn);
          
            Item window = new Item("window");
            Item hammer = new Item("hammer");
            Item throne = new Item("throne");
            throneRoom.addItem(window);
            throneRoom.addItem(hammer);
            throneRoom.addItem(throne);
          
            //City exits and items
            Exit cityWest = new Exit("west", projects);
            Exit citySouth = new Exit("south", wallStreet);
            Exit cityNorth = new Exit("north", barbie);
            city.addExit(cityWest);
            city.addExit(citySouth);
            city.addExit(cityNorth);
          
            Item umbrella = new Item("umbrella");
            Item bottle = new Item("bottle");
            Item backPack = new Item("backpack");
            city.addItem(umbrella);
            city.addItem(bottle);
            city.addItem(backPack);
          
            //projects exits and items
            Exit projectsSouth = new Exit("south", stripClub);
            Exit projectReturn = new Exit("east", city);
            projects.addExit(projectsSouth);
            projects.addExit(projectReturn);
          
            Item nothing = new Item("nothing");
            Item poison = new Item("poison");
            Item wealth = new Item("wealth");
            projects.addItem(nothing);
            projects.addItem(poison);
            projects.addItem(wealth);
          
            //Strip Club
            Exit stripclubReturn = new Exit("north", projects);
            stripClub.addExit(stripclubReturn);
          
            Item typewriter = new Item("typewriter");
            Item computer = new Item("computer");
            Item dog = new Item("dog");
            stripClub.addItem(typewriter);
            stripClub.addItem(computer);
            stripClub.addItem(dog);
          
            //WallStreet exits and items
            Exit wallStreetWest = new Exit("west", bank);
            Exit wallStreetReturn = new Exit("north", city);
            wallStreet.addExit(wallStreetWest);
            wallStreet.addExit(wallStreetReturn);
          
            Item secret = new Item("secret");
            Item money = new Item("money");
            Item life = new Item("life");
            wallStreet.addItem(secret);
            wallStreet.addItem(money);
            wallStreet.addItem(life);
          
           //Bank exits and items
            Exit bankReturn = new Exit("east", wallStreet);
            bank.addExit(bankReturn);
          
            Item deckOfCards = new Item("deck-of-cards");
            Item vegtables = new Item("vegtables");
            Item cheese = new Item("cheese");
            bank.addItem(deckOfCards);
            bank.addItem(vegtables);
            bank.addItem(cheese);
           
            //Barbie exits and Items
            Exit barbieReturn = new Exit("south", city);
            barbie.addExit(barbieReturn);
           
            Item watermelon = new Item("watermelon");
            Item obama = new Item("obama");
            Item mouse = new Item("mouse");
            barbie.addItem(watermelon);
            barbie.addItem(obama);
            barbie.addItem(mouse);

        // Player
        ArrayList<Player> playerArray = new ArrayList<Player>();
        Player b = new Player("Branden", world);
        Player a = new Player("Angeles", world);
        playerArray.add(b);
        playerArray.add(a);
       
        
       
        //MOBs
        MOB burton = new MOB("Burton", island, 5000, 1, playerArray);
        MOB michael2 = new MOB("Michael D", castle, 5100, 1, playerArray);
        MOB megan = new MOB("Megan", desert, 5200, 1, playerArray);
        MOB ethan = new MOB("ethan", city, 5300, 1, playerArray);
        MOB alex = new MOB("Alex", island, 6000, 2, playerArray); 
        MOB jon = new MOB("Jon", castle, 6100, 2, playerArray);
        MOB mom = new MOB("Your Mom", city, 6200, 2, playerArray);
        MOB bae = new MOB("Bae", desert, 6300, 2, playerArray);
        MOB gabe = new MOB("Gabe", desert, 7000, 3, playerArray);
        MOB seth = new MOB("seth", castle, 7100, 3, playerArray);
        MOB ari = new MOB("Ari", island, 7200, 3, playerArray);
        MOB erik = new MOB("Erik", city, 7300, 3, playerArray);
        MOB calvin = new MOB("Calvin", island, 20000, 4, playerArray);
        MOB thomas = new MOB("Thomas", city, 20100, 4, playerArray);
        MOB jose = new MOB("Jose Bowen", castle, 20200, 4, playerArray);
        MOB tom = new MOB("Professor Kelliher", desert, 20300, 4, playerArray);
        MOB michael = new MOB("Michael S", island, 5000, 5, playerArray);;
        MOB madison = new MOB("Madison", city, 5100, 5, playerArray);
        MOB gopher = new MOB("Gopher", desert, 5200, 5, playerArray);
        MOB zimmerman = new MOB("Professor Zimmerman", island, 5300, 5, playerArray);
        
       
       
        //MOB array
        ArrayList<MOB> mobArray = new ArrayList<MOB>();
        mobArray.add(burton);
        mobArray.add(michael2);
        mobArray.add(ethan);
        mobArray.add(mom);
        mobArray.add(bae);
        mobArray.add(burton);
        mobArray.add(seth);
        mobArray.add(ari);
        mobArray.add(erik);
        mobArray.add(thomas);
        mobArray.add(jose);
        mobArray.add(gopher);
        mobArray.add(zimmerman);
        mobArray.add(alex);
        mobArray.add(gabe);
        mobArray.add(calvin);
        mobArray.add(michael);
        mobArray.add(jon);
        mobArray.add(tom);
        mobArray.add(megan);
        mobArray.add(madison);
        ArrayList<Thread> mobThreadArray = new ArrayList<Thread>(mobArray.size());

        
        GUI ui = new GUI(b, mobThreadArray);
        GUI ui2 = new GUI(a, mobThreadArray);
       
        for (int i = 0; i < mobArray.size(); i++)
        {
            mobArray.get(i).addObserver(ui);
            mobArray.get(i).addObserver(ui2);
            Thread mobThread = new Thread(mobArray.get(i));
            mobThreadArray.add(mobThread);
            mobThread.start();
        }
    }
    
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Boot();
        // TODO Auto-generated method stub

    }

}