/**
 * @author (Muhammad Othman Ghani)
 * @version (v 2.0)
 */
import java.util.*;
public class MiniSudoku_InTheTerminalWindow{
    public static void PrintSudokuArt(){
        System.out.println("     e    e        888   888b    |   888          ,d88~~\\   888   |   888~-_       ,88~-_     888  /     888   |");
        System.out.println("    d8b  d8b       888   |Y88b   |   888          8888      888   |   888   \\     d888   \\    888 /      888   |");
        System.out.println("   d888bdY88b      888   | Y88b  |   888   ____   `Y88b     888   |   888    |   88888    |   888/\\      888   |");
        System.out.println("  / Y88Y Y888b     888   |  Y88b |   888           `Y88b,   888   |   888    |   88888    |   888  \\     888   |");
        System.out.println(" /   YY   Y888b    888   |   Y88b|   888             8888   Y88   |   888   /     Y888   /    888   \\    Y88   |");
        System.out.println("/          Y888b   888   |    Y888   888          \\__88P'    \"8__/    888_-~       `88_-~     888    \\    \"8__/\n\n\n\n\n ");
        }
        
    public static void main(String[]args){
        outerLoop: while(true){
            Scanner sc = new Scanner(System.in);
            Random r = new Random();
            String gmnum[] = {"   1. Game #1", "2. Game #2", "3. Game #3", "4. Random Mode"};
            String presetPuzzle[][] = {{"1234", "3412", "2341", "412_"}, {"__4_", "_2__", "___4", "__3_"}};
            String puzzleCheck[][] = {{"1d", "2c", "3c", "4a"}, {"1c", "2b", "3d", "4c"}, {"1c", "2d", "3a", "3c"}, {"1a", "2d", "3b", "4d"}};
            System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            PrintSudokuArt();
            System.out.printf(" Welcome to M I N I - S U D O K U!\n%s \n\n Please select any one of the following options\n\n  1. Play Game\n  2. About\n\n",
                "________________________________________________________________________________________________________________________");
            System.out.println("\n\n Enter 'e' to exit\n");
            String i = getInputLoop(1,'2');
            if(i.charAt(0) == 'e')
                break;
            if(i.compareTo("1") == 0){
                System.out.println("\n Select any one of the following games:\n");
                printAllMembers(gmnum);
                System.out.println("\n\n Enter 'e' to exit\n");
                char gamenumber = getInputLoop(1,'4').charAt(0);
                switch(gamenumber){
                    case 'e':{
                        continue outerLoop;}
                    case '4' :{
                        setAndRun(puzzleCheck[r.nextInt(3)]);
                        break;}
                    default :{
                        if(gamenumber ==  '1' || gamenumber ==  '2'|| gamenumber ==  '3')
                        playGame(presetPuzzle[gamenumber-49], puzzleCheck[gamenumber-49]);
                        else{
                            System.out.println("Invalid input");waitForEnterKey();}
                         break;}
                    }
            }
            else if(i.compareTo("2") == 0){
                PrintSudokuArt();
                gamePrint("\n                                                                 About\n");
                System.out.println("________________________________________________________________________________________________________________________\n The name Sudoku comes from Japan and consists of the Japanese characters"+
                    "\n Su (meaning number), and Doku (meaning single) but the puzzle was not invented"+
                    "\n in Japan. Sudoku originated in Switzerland and then traveled to Japan through"+ 
                    "\n of the USA. Sudoku has its deep roots in ancient number puzzles.\n"+
                    "\n It is from the traditional 9x9 board that this puzzle, M I N I - S U D O K U\n was derived.\n"+
                    "\n This simplified version of Sudoku is easier to complete and can be finished by"+ 
                    "\n most people in under 2 minutes");
                Instructions();
            }
            else{ 
            System.out.println("Invalid input"); waitForEnterKey();}
        }
    }
    public static final char[] EXTENDED = { 0x00C7, 0x00FC, 0x00E9, 0x00E2,
            0x00E4, 0x00E0, 0x00E5, 0x00E7, 0x00EA, 0x00EB, 0x00E8, 0x00EF,
            0x00EE, 0x00EC, 0x00C4, 0x00C5, 0x00C9, 0x00E6, 0x00C6, 0x00F4,
            0x00F6, 0x00F2, 0x00FB, 0x00F9, 0x00FF, 0x00D6, 0x00DC, 0x00A2,
            0x00A3, 0x00A5, 0x20A7, 0x0192, 0x00E1, 0x00ED, 0x00F3, 0x00FA,
            0x00F1, 0x00D1, 0x00AA, 0x00BA, 0x00BF, 0x2310, 0x00AC, 0x00BD,
            0x00BC, 0x00A1, 0x00AB, 0x00BB, 0x2591, 0x2592, 0x2593, 0x2502,
            0x2524, 0x2561, 0x2562, 0x2556, 0x2555, 0x2563, 0x2551, 0x2557,
            0x255D, 0x255C, 0x255B, 0x2510, 0x2514, 0x2534, 0x252C, 0x251C,
            0x2500, 0x253C, 0x255E, 0x255F, 0x255A, 0x2554, 0x2569, 0x2566,
            0x2560, 0x2550, 0x256C, 0x2567, 0x2568, 0x2564, 0x2565, 0x2559,
            0x2558, 0x2552, 0x2553, 0x256B, 0x256A, 0x2518, 0x250C, 0x2588,
            0x2584, 0x258C, 0x2590, 0x2580, 0x03B1, 0x00DF, 0x0393, 0x03C0,
            0x03A3, 0x03C3, 0x00B5, 0x03C4, 0x03A6, 0x0398, 0x03A9, 0x03B4,
            0x221E, 0x03C6, 0x03B5, 0x2229, 0x2261, 0x00B1, 0x2265, 0x2264,
            0x2320, 0x2321, 0x00F7, 0x2248, 0x00B0, 0x2219, 0x00B7, 0x221A,
            0x207F, 0x00B2, 0x25A0, 0x00A0 };
    public static void printC_or_I(int a, int b){//Corner or Intersection(with simple horizontal lines in between)
        for (int n = 0; n <=22; n++){//'n' is a variable to store the number of characters already printed 
            //on the screen, 22 being the limit
            if(n==11)
                System.out.printf("%s", getAscii(a));
            else
                System.out.printf("%s", getAscii(195));
            if(n==22)
                System.out.printf("%s", getAscii(b));
        }
    }

    public static final char getAscii(int code) {//used to print extended ASCII code of charValue 'code'
        if (code >= 0x80 && code <= 0xFF) {
            return EXTENDED[code - 0x7F];
        }
        return (char) code;
    }

    public static void Instructions(){
        String a[] = {"How to Play  M I N I   S U D O K U.",
                "\n\n- The objective is to fill a 4x4 grid so that each column, each row, ",
                "\n  and each of the four 2x2 boxes (also called blocks or regions)",
                "\n  contains the digits from 1 to 4.",
                "\n\n- Each row, column, and quadret(2x2 box) can contain any number\n from 1 to 4 only once.\n\n  ",
                "Once you finish reading the instructions, press the enter key"};
        gamePrint("\n                                                              Instructions");
        gamePrint("");
        printAllMembers(a);
        gamePrint("");
        waitForEnterKey();
    }

    public static boolean runThru(String coOrdinate, String arr[]){//checks if coordinates on grid,'coOrdinate' are vaalid by
        //comparing them to members of array 'arr[]'
        for(int i = 0; i<arr.length; i++){
            if (coOrdinate.compareTo(arr[i]) == 0)
                return true;
        }
        return false;
    }

    public static void gamePrint(String s){//simply prints a line followed by some text 'String s'
        System.out.println("\n________________________________________________________________________________________________________________________\n" +s);
    }

    public static void printAllMembers(String s[]){//prints all memebers of array 'String s[]'
        for(int i = 0; i<s.length; i++)
            System.out.print("  "+s[i]);
    }

    public static String getInputLoop(int a, char c){//A loop that manages a majority of the inputs concerned with
        //the completion of the game, handling most errors.
        String s = "";
        while(true){
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            if((s.length() == a && s.charAt(0)>='1' && s.charAt(0)<= c) || s.compareTo("i") == 0 
            || s.compareTo("q")==0 || s.compareTo("e")==0)
                if(s.length() == 2){
                    if(s.charAt(1) >= 'a' && s.charAt(1) <= 'd'){
                        break;}}
                else
                    break;
            System.out.println("\nInvalid input\n");
        }
        return s;
    }

    public static void waitForEnterKey(){
        Scanner sc = new Scanner(System.in);
        String zeroConsequence = sc.nextLine();
    }

    public static int giveFrequency(char a, String s){
        int num = 0;
        for (int i = 0; i<s.length(); i++){
            if(s.charAt(i)==a)
                num++;
        }
        return num;
    }

    public static boolean finCheck(String arr[]){
        double sumRows = 0, sumColumns = 0, productRows = 1, productColumns =1;
        for(int rowColumn = 0; rowColumn < arr.length ; rowColumn++){
            for(int columnRow = 0; columnRow < arr.length; columnRow++){
                sumRows += (arr[rowColumn].charAt(columnRow) - 48);
                sumColumns += (arr[columnRow].charAt(rowColumn) - 48);
                productRows *= (arr[rowColumn].charAt(columnRow) - 48);
                productColumns *= (arr[columnRow].charAt(rowColumn) - 48);
            }}
        if (sumRows==sumColumns && sumRows == 40 && productRows==productColumns && productRows== 24*24*24*24)
            return true;
        return false;
    }

    public static void printLine(String arr, int lineNumber, String chck[]){
        System.out.format("\n %d    %s  ",(lineNumber+1),getAscii(178));
        for(int i = 0; i< arr.length(); i++){
            char x = 'a', y = '1';
            for(int a = 0; a < i;a++)
                x++;
            for(int a = 0; a < lineNumber;a++)
                y++;
            String c = ""+y+x;
            if(runThru(c, chck)==true)
                System.out.format(" %s*", arr.charAt(i));
            else
                System.out.format(" %s ", arr.charAt(i));
            if(i == Math.sqrt(4)-1)
                System.out.printf("  %s  ", getAscii(178));
            else
                System.out.printf(" ");
        }
    }

    public static void printGrid(String arr[], String chck[]){
        char a = 'a';
        System.out.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n           %s   %s       %s   %s\n\n      %s", a++, a++, a++, a, getAscii(217));
        printC_or_I(193, 190);
        System.out.printf("\n      %s           %s           %s",getAscii(178), getAscii(178), getAscii(178));
        for(int i = 0; i<arr.length; i++){
            printLine(arr[i], i, chck);
            System.out.printf(" %s", getAscii(178));
            if(i==1){
                System.out.printf("\n      %s           %s           %s\n      %s", getAscii(178), getAscii(178), getAscii(178), getAscii(194));
                printC_or_I(196, 179);
                System.out.printf("\n      %s           %s           %s", getAscii(178), getAscii(178), getAscii(178));
            }
            else if(i<(arr.length-1))
                System.out.printf("\n      %s           %s           %s",getAscii(178), getAscii(178), getAscii(178));
            if (i == arr.length-1){
                System.out.printf("\n      %s           %s           %s",getAscii(178), getAscii(178), getAscii(178));
                System.out.printf("\n      %s", getAscii(191));
                printC_or_I(192, 216);
            }
        }
    }

    public static void playGame(String arr[], String arc[]){
        Scanner sc = new Scanner(System.in);
        gamePrint("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        double startTime = System.currentTimeMillis();
        outerLoop :
        while(finCheck(arr) == false){;
            printGrid(arr, arc);
            gamePrint("\n\nEnter the coordinates of the number/space you wish to change\nin the 'numberLetter' format. Eg. '1a'"+
                "\n\nTo read the instructions enter 'i'\nTo quit the game enter 'q'\nYou cannot change:\n");
            printAllMembers(arc);
            System.out.println("\n");
            String c1 = getInputLoop(2, '4');
            if(c1.compareTo("i") == 0)
                Instructions();
            else if(c1.compareTo("q") == 0){
                while(true){
                    System.out.println("Do you wish to quit this game?");
                    String decisionFinal = sc.nextLine();
                    if(decisionFinal.toLowerCase().compareTo("yes") == 0 ||  decisionFinal.toLowerCase().compareTo("yeah") == 0)
                         break outerLoop;
                    else if(decisionFinal.toLowerCase().compareTo("no") == 0 ||  decisionFinal.toLowerCase().compareTo("nope") == 0){
                         System.out.println("Press the enter key to continue playing this game....");
                         waitForEnterKey();
                         break;}
                    else
                         System.out.println(" Invalid input, I do not understand. \n Please use only yes, yeah, no and nope(not case sensitive)");
                } 
            }               
            else{
                if(runThru(c1, arc)==false){
                    int x = c1.charAt(1) - 97, y = c1.charAt(0) - 49;
                    System.out.println("Enter the number to replace the selected space/number");
                    int c;
                    try{
                        c = sc.nextInt();
                        if(c>0 && c<5)
                         c=c;
                        else
                         c/=0;
                        }
                    catch(Exception e){
                        System.out.println("Invalid input, press the 'enterKey'");
                        waitForEnterKey();
                        continue;}
                    String temp = arr[y].substring(0,x) + Integer.toString(c) + arr[y].substring((x+1),4);
                    arr[y]=temp;
                    gamePrint( "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                }
                else{
                    System.out.println("\nInvalid input. This number is permanent, \nyou must finish the game by filling blanks and changing nunbers that do not\nend with an asterisk(*)\n"+
                    "Please press the enter key in order to continue...\n");
                    waitForEnterKey();
                }
            }
        }
        printGrid(arr, arc);
        double Time = (System.currentTimeMillis() - startTime)/1000;
        if(finCheck(arr) == true){
            gamePrint(" CONGRATULATIONS! YOU'VE WON!      ");
            System.out.print(" Time taken : " + Time + " s\n Click 'Enter' to return to the main menu");
            waitForEnterKey();}
    }
    
    public static String[] generateRandom(){
        System.out.println("This may take a few moments.....");
        String s[] = {"", "", "", ""};
        Random r = new Random();
        int i = 0;
        double startTime = System.currentTimeMillis();
        outermostLoop:
        while(true){
            outerLoop:
            while(true){
                if((System.currentTimeMillis() - startTime)/1000 > 1){
                    i = 0;
                    startTime = System.currentTimeMillis();
                    for(int count = 0; count < 4; count++)
                        s[count] = "";
                    break;}
                String x = "1234", backup = s[i];
                char num = x.charAt(r.nextInt(4));
                s[i] += num;
                for(int a = 0; a < s[i].length()-1; a++)
                    if (num == s[i].charAt(a)){
                        s[i] = backup;
                        continue outerLoop;}
                for(int b = 0; b < i; b++)
                    if (num == s[b].charAt(s[i].length()-1)){
                        s[i] = backup;
                        continue outerLoop;}
                if(i == 1 || i == 3) 
                    if((s[i].length()-1)%2 != 0){
                        if(num == s[i-1].charAt(s[i].length()-1) || num == s[i-1].charAt(s[i].length()-2)){
                            s[i] = backup;
                            continue outerLoop;}
                        }
                        else{ 
                            if(num == s[i-1].charAt(s[i].length()-1) || num == s[i-1].charAt(s[i].length())){
                                s[i] = backup;
                                continue outerLoop;}
                            }
                if (i == 3 && s[i].length() == 4)
                    break outermostLoop;
                if(s[i].length() == 4)
                    i++;
              }
            }
        for(int a = 0; a < 4; a++)
            System.out.println(s[a]);      
        System.out.println("END");
        return s;
    }
    
    public static void setAndRun(String s[]){
        String gameRandom[] = generateRandom(), gameSet[] = new String[4];
        for(int i = 0; i < 4; i++){
            gameSet[i] = "";
            for(int a = 0; a < 4; a++)
                for(int indexIncluder = 0; indexIncluder < s.length; indexIncluder++)
                    if(a == s[indexIncluder].charAt(1)-97 && i == s[indexIncluder].charAt(0)-49){
                        gameSet[i] += gameRandom[i].charAt(a);
                        break;}
                    else if(indexIncluder == s.length -1)
                        gameSet[i] += '_';
          }
        playGame(gameSet, s);
    
    }
}