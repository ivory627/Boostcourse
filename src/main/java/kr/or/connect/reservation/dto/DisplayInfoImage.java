package kr.or.connect.reservation.dto;

public class DisplayInfoImage {
	private int id;
	private int displayInfoId;
	private int fileId;
	public DisplayInfoImage() {
		super();
	}
	public DisplayInfoImage(int id, int displayInfoId, int fileId) {
		super();
		this.id = id;
		this.displayInfoId = displayInfoId;
		this.fileId = fileId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "DisplayInfoImage [id=" + id + ", displayInfoId=" + displayInfoId + ", fileId=" + fileId + "]";
	}
	
	
}
