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
 * NodeConnector.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 *
 * Original Author: Philipp Neubrand;
 * Contributors:    -;
 *
 * ---------------------------------------
 */
package gtna.networks.model.placementmodels;

import gtna.graph.Edges;
import gtna.graph.Node;
import gtna.id.plane.PlaneIdentifierSpaceSimple;
import gtna.util.Util;

/**
 * @author Flipp
 * 
 */
public abstract class AbstractNodeConnector {
	private String key;

	private String[] additionalConfigKeys;

	private String[] additionalConfigValues;

	public void setAdditionalConfigKeys(String[] additionalConfigKeys) {
		this.additionalConfigKeys = additionalConfigKeys;
	}

	public void setAdditionalConfigValues(String[] additionalConfigValues) {
		this.additionalConfigValues = additionalConfigValues;
	}

	public abstract Edges connect(Node[] nodes, PlaneIdentifierSpaceSimple ids);

	/**
	 * @return
	 */
	public String[] getConfigKeys() {
		return Util.mergeArrays(new String[] { "KEY" }, additionalConfigKeys);
	}

	/**
	 * @return
	 */
	public String[] getConfigValues() {
		return Util.mergeArrays(new String[] { getKey() },
				additionalConfigValues);
	}

	/**
	 * @return
	 */
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
