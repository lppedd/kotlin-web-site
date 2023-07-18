package builds.apiReferences.stdlib

import jetbrains.buildServer.configs.kotlin.AbsoluteId
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.FailureAction
import jetbrains.buildServer.configs.kotlin.ReuseBuilds

object BuildStdlibApiReference : BuildType({
    name = "Stdlib Api reference"

    artifactRules = "latest-version.zip"

    vcs {
        root(vcsRoots.KotlinLangOrg)
    }

    params {
        param("revers.deps.*.templatesBranch", "ktl-696-dokka-stdlib")
    }

    dependencies {
        dependency(AbsoluteId("Kotlin_KotlinRelease_190_LibraryReferenceLatestDocs")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
                onDependencyFailure = FailureAction.FAIL_TO_START
            }
            artifacts {
                cleanDestination = true
                artifactRules = "latest-version.zip"
            }
        }
    }
})