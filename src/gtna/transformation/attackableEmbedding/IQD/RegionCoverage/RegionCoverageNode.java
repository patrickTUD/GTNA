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
 * RegionCoverageNode.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 *
 * Original Author: stef;
 * Contributors:    -;
 *
 * Changes since 2011-05-17
 * ---------------------------------------
 *
 */
package gtna.transformation.attackableEmbedding.IQD.RegionCoverage;

import gtna.graph.Graph;
import gtna.id.ring.RingIdentifierSpace.Distance;
import gtna.transformation.attackableEmbedding.IQD.DecisionNode;
import gtna.transformation.attackableEmbedding.IQD.IQDEmbedding;

import java.util.Random;
import java.util.Vector;

/**
 * @author stef
 *
 */
public class RegionCoverageNode extends DecisionNode {

	/**
	 * @param index
	 * @param g
	 * @param embedding
	 */
	public RegionCoverageNode(int index, Graph g, IQDEmbedding embedding) {
		super(index, g, embedding);
	}

	/* (non-Javadoc)
	 * @see gtna.transformation.attackableEmbedding.IQD.IQDNode#getQuality(java.util.Random, double[])
	 */
	@Override
	public double[] getQuality(Random rand, double[] ids) {
		double[] res = new double[ids.length];
		double log2 = Math.log(2);
		double dist;
		int r;
		int max = ((RegionCoverageEmbedding)this.embedding).getMax();
		for (int i = 0; i < res.length; i++){
			Vector<Integer> numb = new Vector<Integer>(this.knownIDs.length);
			for (int j = 0; j < this.knownIDs.length; j++){
				dist = this.embedding.computeDistance(this.knownIDs[j], ids[i]);
				r = (int) (Math.min(Math.ceil(-Math.log(Math.abs(dist))/log2),max)*Math.signum(dist));
				if (!numb.contains(r)){
					numb.add(r);
				}
				if (this.embedding.getDistance() == Distance.SIGNED && numb.size() == 2*(max-1)){
					break;
				}
				if (this.embedding.getDistance() == Distance.RING && numb.size() == (max-1)){
					break;
				}
				if (this.embedding.getDistance() == Distance.CLOCKWISE && numb.size() == max){
					break;
				}
			}
			res[i] = numb.size();
		}
		return res;
	}

}