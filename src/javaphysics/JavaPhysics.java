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

import javax.swing.JFrame;

/*
 * JavaPhysics Class
 * 
 * Program Start-Up
 * 
 * @package     javaphysics
 * @category    Start-Up
 * @author      Richard Dahlgren
 */
public final class JavaPhysics {
    
    private final JFrame window = new JFrame("Java Physics");
    
    // -------------------------------------------------------------------------
    
    /*
     * Constructor
     * 
     */
    public JavaPhysics() {
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setSize(400, 400);
        this.window.setLocationRelativeTo(null);
        this.window.setResizable(false);
        
        final PhysicsPanel physicsPanel = new PhysicsPanel();
        this.window.getContentPane().add(physicsPanel);
        
        this.window.setVisible(true);
    }

    /*
     * Main-Constructor
     * 
     */
    public static void main(final String[] args) {
        final JavaPhysics javaPhysics = new JavaPhysics();
    }
}
