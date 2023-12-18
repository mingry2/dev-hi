package com.example.devhi.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import java.sql.Blob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;			// user 고유번호
	@Column(nullable = false)
	private String loginId;		// 로그인 ID
	@Column(nullable = false)
	private String password;	// 패스워드
	private String email;		// 메일주소 == 깃허브주소
	private String blogAdr;		// 블로그주소
	private String githubAdr;	// 깃허브주소
	private String alias;		// 별명
	private int age;			// 나이
	private int gender;			// 성별
	private String experience;	// 경험&경력
	private String intro;		// 자기소개
	@Lob
	private Blob profileImage;	// 프로필이미지

	// OAuth
	private String provider;
	private String providerId;

}
