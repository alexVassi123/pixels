package be.ugent.pixels;

import be.ugent.pixels.model.*;
import be.ugent.pixels.view.PixelView;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    private static String pathToTextFiles = System.getProperty("user.dir") + "/src/main/resources/be/ugent/pixels/files/";
    private static String FILE = "smallOne.txt";
    //private static String FILE = "bigOne.txt";


    public static void main(String[] args) {
        showOnConsole();
   //    showOnGraphicalUserInterface();
    }

    public static void showOnConsole() {
        try {
            PixelGrid grid = new PixelGrid(pathToTextFiles+FILE);
           // System.out.println(grid);
            grid.readFile();
            System.out.println(grid.getHeight());
            System.out.println(grid.getWidth());
            System.out.println(grid.getStartCoordinate());

            for (RouteStep step : grid.getRoute()) {
                System.out.println(step);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! "+pathToTextFiles+FILE);
        }
    }

    public static void showOnGraphicalUserInterface() {
        try {
            PixelGrid grid = new PixelGrid(pathToTextFiles + FILE);
            PixelView view = new PixelView(grid);
            view.setVisible(true);
        } catch (FileNotFoundException e) {
            System.out.println("bestand niet gevonden" + e.getMessage());
        }
    }


}










