/* ===========================================================
 * GTNA : Graph-Theoretic Network Analyzer
 * ===========================================================
 *
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors
 *
 * Project Info:  http://www.p2p.tu-darmstadt.de/research/gtna/
 *
 * GTNA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GTNA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * ---------------------------------------
 * IntArrayParameter.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 *
 * Original Author: benni;
 * Contributors:    -;
 *
 * Changes since 2011-05-17
 * ---------------------------------------
 *
 */
package gtna.util.parameter;

/**
 * @author benni
 * 
 */
public class IntArrayParameter extends Parameter {
	private int[] intArrayValue;

	public IntArrayParameter(String key, int[] intArrayValue) {
		super(key, IntArrayParameter.toString(intArrayValue));
		this.intArrayValue = intArrayValue;
	}

	public int[] getIntArrayValue() {
		return this.intArrayValue;
	}

	private static String toString(int[] v) {
		StringBuffer buff = new StringBuffer();
		for (int i : v) {
			if (buff.length() == 0) {
				buff.append(i);
			} else {
				buff.append("_" + i);
			}
		}
		return buff.toString();
	}

}
