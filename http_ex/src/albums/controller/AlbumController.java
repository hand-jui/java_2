package albums.controller;

import albums.dto.AlbumDTO;
import albums.service.AlbumService;

public class AlbumController {

	private AlbumService albumService;
	
	public AlbumController() {
		albumService = new AlbumService();
	}
	
	public int savePhoto(AlbumDTO album) {
		
		if(album.getUserId()!=0) {
			return albumService.save(album);
		}
		return 0;
	}
}
