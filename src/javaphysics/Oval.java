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

/*
 * Oval Class
 * 
 * Oval Data Storage
 * 
 * @package     javaphysics
 * @category    Oval
 * @author      Richard Dahlgren
 */
public final class Oval {
    
    public float x;
    public float y;
    public float xVelocity;
    public float yVelocity = 0.0f;
    public final int size;
    
    // -------------------------------------------------------------------------
    
    /*
     * Constructor
     * 
     */
    public Oval(final int x, final int y, final float xVelocity, final int size) {
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.size = size;
    }
}
