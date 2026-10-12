
package be.ugent.pixels.model;

import be.ugent.pixels.model.DPoint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PixelGrid{

    private int height;
    private int width;
    private DPoint startCoordinate;
    private final String filename;

    private final List<RouteStep> route = new ArrayList<>();



    public PixelGrid(String filename) throws FileNotFoundException {
        this.filename = filename;

    }

    public void readFile(){
        try (Scanner fileReader = new Scanner(new File(filename))){
            String[] dimensions = fileReader.nextLine().split(" ");
            height = Integer.parseInt(dimensions[0]);
            width = Integer.parseInt(dimensions[1]);

            String[] startCoordinates = fileReader.nextLine().split(" ");
            startCoordinate = new DPoint(Integer.parseInt(startCoordinates[0]), Integer.parseInt(startCoordinates[1]));


            while(fileReader.hasNext()){
                String[] step = fileReader.nextLine().split(" ");
                route.add(new RouteStep(step[0], step[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public DPoint getStartCoordinate() {
        return this.startCoordinate;
    }

    public List<RouteStep> getRoute() {
        return route;
    }

    public char getCellContent(int x, int y){
        if((x+y)%2 == 0){
            return 'X';
        }
        else{
            return '.';
        }
    }

    public String toString(){
        return "X.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\n";
    }

}
