/**
 * 
 */
package shared.communicator;

import shared.locations.VertexLocation;

/**
 * @author campbeln
 *
 */
public class BuildCityParams {

	private int playerIndex;
	private VertexLocation vertexLocation;
	
	public BuildCityParams(int playerIndex, VertexLocation vertexLocation) {
		this.playerIndex = playerIndex;
		this.vertexLocation = vertexLocation;
	}

	/**
	 * @return the playerIndex
	 */
	public int getPlayerIndex() {
		return playerIndex;
	}

	/**
	 * @param playerIndex the playerIndex to set
	 */
	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}

	/**
	 * @return the vertexLocation
	 */
	public VertexLocation getVertexLocation() {
		return vertexLocation;
	}

	/**
	 * @param vertexLocation the vertexLocation to set
	 */
	public void setVertexLocation(VertexLocation vertexLocation) {
		this.vertexLocation = vertexLocation;
	}
	
}