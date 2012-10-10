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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/*
 * PhysicsPanel Class
 * 
 * Handle Drawing
 * 
 * @package     javaphysics
 * @category    Drawing
 * @author      Richard Dahlgren
 */
public final class PhysicsPanel extends JPanel {
    
    private final BufferedImage imageToDraw;
    private final Graphics2D graphicsToDraw;
    
    private final UpdateThread updateClass;
    private final Thread updateThread;
    
    private final OvalManager ovalManager = new OvalManager();
    
    // -------------------------------------------------------------------------
    
    /*
     * Constructor
     * 
     */
    public PhysicsPanel() {
        this.imageToDraw = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        this.graphicsToDraw = this.imageToDraw.createGraphics();
        
        this.updateClass = new UpdateThread(this);
        this.updateThread = new Thread(this.updateClass);
        this.updateThread.start();
    }
    
    /*
     * PaintComponent
     * 
     * Draw to screen
     * 
     * @access  public
     * @param   Graphics
     */
    @Override
    public final void paintComponent(final Graphics graphics) {
        this.graphicsToDraw.setColor(Color.BLACK);
        this.graphicsToDraw.fillRect(0, 0, 400, 400);
        this.graphicsToDraw.setColor(Color.BLUE);
        
        Oval ovalRef;
        for (int oval = 0; oval < this.ovalManager.ovalHash.size(); oval++) {
            ovalRef = this.ovalManager.ovalHash.get(oval);
            
            this.graphicsToDraw.drawOval((int) ovalRef.x, (int) ovalRef.y, ovalRef.size, ovalRef.size);
        }
        
        graphics.drawImage(this.imageToDraw, 0, 0, 400, 400, null);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }
    
    /*
     * UpdateFrame
     * 
     * Update Frame Content
     * 
     * @access  public
     */
    public final void updateFrame() {
        this.ovalManager.moveOvals();
        this.repaint();
    }
}
