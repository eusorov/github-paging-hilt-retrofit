package com.example.android.codelabs.paging.model

data class RepositoryViewData (
    val id: Long,
    val ownerId: Long,
    val ownerName: String,
    val ownerImage: String,
    val repositoryName: String,
    val repositoryUrl: String,
    val repositoryDescription: String
)