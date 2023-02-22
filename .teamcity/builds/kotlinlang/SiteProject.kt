package builds.kotlinlang

import builds.kotlinlang.buidTypes.*
import builds.kotlinlang.templates.DockerImageBuilder
import builds.kotlinlang.vcs.GrammarGenerator
import builds.kotlinlang.vcs.KotlinSpec
import builds.kotlinlang.vcs.WebHelp
import jetbrains.buildServer.configs.kotlin.Project

object SiteProject : Project({
  name = "Build kotlinlang.org"

  buildType(BuildJsAssets)
  buildType(BuildKotlinSpec)
  buildType(BuildKotlinGrammar)
  buildType(BuildWebHelpFrontend)
  buildType(BuildReferenceDocs)
  buildType(BuildSitePages)

  template(DockerImageBuilder)

  vcsRoot(GrammarGenerator)
  vcsRoot(KotlinSpec)
  vcsRoot(WebHelp)
})