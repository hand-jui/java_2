package albums.service;

import albums.dao.AlbumDAO;
import albums.dto.AlbumDTO;

public class AlbumService {
	
	private AlbumDAO albumDAO;
	
	public AlbumService() {
		albumDAO = new AlbumDAO();
	}
	
	public int save(AlbumDTO album) {
		int resultRowCount = 0;
		
		if(album.getTitle().equals("") || album.getTitle().length()<2) {
			return resultRowCount;
		}
		resultRowCount = albumDAO.insert(album);
		return resultRowCount;
	}
}
