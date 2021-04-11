package hello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Turmite extends GameObject {
    
    Environment environment;
    Handler handler;
    protected int dir;
    protected int UP, RIGHT, DOWN, LEFT;
    protected String rules;
    protected int state;
    protected char left, right;

    public Turmite(int x, int y, String rules, ID id, Handler handler, Environment environment) {
        super(x, y, id);
        this.handler = handler;
        this.environment = environment;
        this.rules = rules;
        dir = 0;
        UP = 0;
        RIGHT = 1;
        DOWN = 2;
        LEFT = 3;
        left = 'L';
        right = 'R';
    }

    public void tick(){
        for(int i = 0; i < 1000; i++){
            state = this.environment.grid[this.x][this.y]; 
            int listLength = this.rules.length();
            for(int j = 0; j < listLength; j++){
                if(state == j){
                    if(this.rules.charAt(j) == left){
                        turnLeft();
                        this.environment.grid[this.x][this.y] = (j + 1) % (listLength);
                    }
                    else if(this.rules.charAt(j) == right){
                        turnRight();
                        this.environment.grid[this.x][this.y] = (j + 1) % (listLength);
                    }
                }
            }
            moveForward();
        }
    }

    // public void tick(){
    //     for(int i = 0; i < 1000; i++){
    //     state = this.environment.grid[this.x][this.y]; 
    //     if(state == 0){
    //         if(this.rules.charAt(0) == left){
    //             turnLeft();
    //             this.environment.grid[this.x][this.y] = 1;
    //         }
    //         else if(this.rules.charAt(0) == right){
    //             turnRight();
    //             this.environment.grid[this.x][this.y] = 1;
    //             }
    //         }
    //     if(state == 1){
    //         if(this.rules.charAt(1) == left){
    //             turnLeft();
    //             this.environment.grid[this.x][this.y] = 2;
    //         }
    //         else if(this.rules.charAt(1) == right){
    //             turnRight();
    //             this.environment.grid[this.x][this.y] = 2;
    //             }
    //         }  
    //     if(state == 2){
    //         if(this.rules.charAt(2) == left){
    //             turnLeft();
    //             this.environment.grid[this.x][this.y] = 3;
    //         }
    //         else if(this.rules.charAt(2) == right){
    //             turnRight();
    //             this.environment.grid[this.x][this.y] = 3;
    //             }
    //         }
    //     if(state == 3){
    //         if(this.rules.charAt(3) == left){
    //             turnLeft();
    //             this.environment.grid[this.x][this.y] = 0;
    //         }
    //         else if(this.rules.charAt(3) == right){
    //             turnRight();
    //             this.environment.grid[this.x][this.y] = 0;
    //             }
    //         } 
    //         moveForward();                  
    //     }
    // }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x * Game.scale, y * Game.scale, 1, 1);
    }
    private void moveForward() {
        if (this.dir == UP) {
          this.y--;
        } else if (this.dir == RIGHT) {
          this.x++;
        } else if (this.dir == DOWN) {
          this.y++;
        } else if (this.dir == LEFT) {
          this.x--;
        }
        if (this.x > Game.WIDTH/Game.scale -1) {
          this.x = 0;
        } else if (this.x < 0) {
          this.x = Game.WIDTH/Game.scale -1;
        }
        if (this.y > Game.HEIGHT/Game.scale -1) {
          this.y = 0;
        } else if (this.y < 0) {
          this.y = Game.HEIGHT/Game.scale -1;
        }
      }
      private void turnLeft() {
        this.dir--;
        if (this.dir < UP) {
          this.dir = LEFT;
        }
      }
      private void turnRight() {
        this.dir++;
        if (this.dir > LEFT) {
          this.dir = UP;
        }
      }
}
