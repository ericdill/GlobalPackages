/*******************************************************************************
 * Copyright (c) 2013 Eric Dill -- eddill@ncsu.edu. North Carolina State University. All rights reserved.
 * This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Eric Dill -- eddill@ncsu.edu - initial API and implementation
 ******************************************************************************/
/**
 * @author Eric D. Dill eddill@ncsu.edu
 * @author James D. Martin jdmartin@ncsu.edu
 * Copyright � 2010-2013 North Carolina State University. All rights reserved
 */
package cuda;

import pixel.JPixel;
import chemistry.JAtom;

public final class Diffraction {
	private static boolean inEclipse = true;
	private static boolean bit32 = false;
	public native JPixel[] calcDiffraction(JAtom[] lattice, JPixel[] pixels, int[] elemTypes);
	private static native void cuInit();
	static {
		if(!inEclipse) {
			if(bit32) { System.loadLibrary("Diffraction32"); }
			else { System.loadLibrary("Diffraction64"); }
			cuInit();
		}
	}
}
