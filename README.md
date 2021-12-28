# github-paging-hilt-retrofit

This repository contains a simple app that implements Dagger-Hilt in MVVM architecture, Retrofit using Kotlin.

#### The app has following packages:
1. api : contains the Github retrofit service: searchRepos() and getUser()
2. data : contains GitHubRepository: calls the GithubPagingSource. And GithubPagingSource which call the service.
3. di: It contains the files required by Hilt
4. models: contains data model for the view.
5. ui: Activity with ViewModel and Adapter for displaying data.


[Tutorial for using Paging 3 with Flow] (https://medium.com/androiddevelopers/introduction-to-paging-3-0-in-the-mad-skills-series-648f77231121)
