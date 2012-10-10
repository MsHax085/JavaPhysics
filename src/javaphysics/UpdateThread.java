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
 * UpdateThread Class
 * 
 * Handle Frame Updating
 * 
 * @package     javaphysics
 * @category    Frame Updating
 * @author      Richard Dahlgren
 */
public final class UpdateThread implements Runnable {
    
    private final PhysicsPanel physicsPanel;
    private boolean update = false;
    
    // -------------------------------------------------------------------------
    
    /*
     * Constructor
     * 
     */
    public UpdateThread(final PhysicsPanel physicsPanel) {
        this.physicsPanel = physicsPanel;
    }

    /*
     * Run
     * 
     * Runnable thread to handle frame updating
     * 
     * @access  public
     */
    @Override
    public void run() {
        this.update = true;
        while (update) {
            this.physicsPanel.updateFrame();
            
            try {
                Thread.sleep(20);// About 50 FPS
            } catch (InterruptedException ex) {
                // Catch Exception?
            }
        }
    }
}
