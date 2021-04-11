package hello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Environment {

    protected int x, y;
    protected int cellWidth, cellHeight;
    public int [] [] grid;

    public Environment(int x, int y, int cellWidth, int cellHeight) {
        this.x = x;
        this.y = y;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        grid = new int [this.x][this.y];
        for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                grid[i][j] = 0;
            }
        }
    }

    public void render(Graphics g){     
        for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                if(grid[i][j] == 1){
                    g.setColor(Color.black);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 2){
                    g.setColor(Color.blue);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 3){
                    g.setColor(Color.green);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 4){
                    g.setColor(Color.red);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 5){
                    g.setColor(Color.yellow);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 6){
                    g.setColor(Color.magenta);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 7){
                    g.setColor(Color.cyan);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 8){
                    g.setColor(Color.pink);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 9){
                    g.setColor(Color.orange);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 10){
                    g.setColor(Color.gray);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
                else if(grid[i][j] == 11){
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
            }
        }
    }
}
