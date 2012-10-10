/*
    * JavaPhysics, Simple 2D Oval Movement.
    * Copyright (C) 2012 Richard Dahlgren
    * 
    * This program is free software; you can redistribute it and/or modify
    * it under the terms of the GNU General Public License as published by
    * the Free Software Foundation; either version 3 of the License, or
    * (at your option) any later version.
    * 
    * This program is distributed in the hope that it will be useful,
    * but WITHOUT ANY WARRANTY; without even the implied warranty of
    * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    * GNU General Public License for more details.
    * 
    * You should have received a copy of the GNU General Public License
    * along with this program; if not, write to the Free Software Foundation,
    * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */

package javaphysics;

import java.util.Random;
import java.util.WeakHashMap;

/*
 * OvalManager Class
 * 
 * Handle Oval Creation And Movement
 * 
 * @package     javaphysics
 * @category    Oval
 * @author      Richard Dahlgren
 */
public final class OvalManager {
    
    private final float Y_ACCELERATION = 0.25f;
    
    public final WeakHashMap<Integer, Oval> ovalHash = new WeakHashMap<Integer, Oval>();
    private final Random random = new Random();
    
    // -------------------------------------------------------------------------
    
    /*
     * Constructor
     * 
     */
    public OvalManager() {
        this.generateOvals();
    }
    
    /*
     * GenerateOvals
     * 
     * Generate Random Ovals
     * 
     * @access  private
     */
    private void generateOvals() {
        this.ovalHash.clear();
        final int generateOvals = this.random.nextInt(15) + 3;
        int x, y, size;
        float xVelocity;
        
        for (int oval = 0; oval < generateOvals; oval++) {
            x = this.random.nextInt(300) + 50;
            y = this.random.nextInt(50) + 20;
            size = this.random.nextInt(30) + 30;
            xVelocity = (this.random.nextInt(2) == 0) ? -1 * (size / 20) : size / 20;
            
            this.ovalHash.put(oval, new Oval(x, y, xVelocity, size));
        }
    }
    
    /*
     * MoveOvals
     * 
     * Handle Oval Movement
     * 
     * @access  public
     */
    public final void moveOvals() {
        Oval ovalRef;
        for (int oval = 0; oval < this.ovalHash.size(); oval++) {
            ovalRef = this.ovalHash.get(oval);
            
            ovalRef.yVelocity += this.Y_ACCELERATION;
            
            ovalRef.x += ovalRef.xVelocity;
            ovalRef.y += ovalRef.yVelocity;
            
            if (ovalRef.x < 0) {
                ovalRef.xVelocity *= -0.8f;
                ovalRef.x = 0;
            } else if (ovalRef.x > 400 - ovalRef.size) {
                ovalRef.xVelocity *= -0.8f;
                ovalRef.x = 400 - ovalRef.size;
            }
            
            if (ovalRef.y > 370 - ovalRef.size) {
                ovalRef.yVelocity *= -0.8f;
                ovalRef.xVelocity *= 0.99f;// Ground Friction
                ovalRef.y = 370 - ovalRef.size;
            }
        }
    }
}
