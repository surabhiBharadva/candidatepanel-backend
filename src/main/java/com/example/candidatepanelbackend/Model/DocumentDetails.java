package com.example.candidatepanelbackend.Model;

import java.math.BigInteger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DocumentDetails")
public class DocumentDetails  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fileName;
	private String type;

	private Double size;

	private String hash;

	@Lob
	private byte[] fileData;

	@OneToOne
	@JoinColumn(name = "candidateId")
	private Candidate candidateId;

//	private String candidateId;

//	private Status status;

	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;

	private String deleteFlag;

	public static final int RADIX = 16;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static int getRadix() {
		return RADIX;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public Candidate getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Candidate candidateId) {
		this.candidateId = candidateId;
	}

	public String getHash() {
		return hash;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public void setHash() throws NoSuchAlgorithmException {
		String trasformedName = new StringBuilder().append(this.fileName).append(this.type).append(this.size)
				.append(new Date().getTime()).toString();

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(trasformedName.getBytes(StandardCharsets.UTF_8));

		this.hash = new BigInteger(1, messageDigest.digest()).toString(RADIX);
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "DocumentDetails [id=" + id + ", fileName=" + fileName + ", type=" + type + ", size=" + size + ", hash="
				+ hash + ", fileData=" + Arrays.toString(fileData) + ", candidateId=" + candidateId + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", modifiedDate=" + modifiedDate + ", modifiedBy="
				+ modifiedBy + ", deleteFlag=" + deleteFlag + "]";
	}

}