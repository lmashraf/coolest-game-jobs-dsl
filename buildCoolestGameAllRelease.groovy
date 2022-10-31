pipelineJob('build-coolest-game-all-release')
{
    def git_repository = 'https://' + System.getenv('git_token') + '@github.com/lmashraf/coolest-game.git'

    description("Pipeline to build and test Release version of the Coolest Game Project")

    definition
    {
        cpsScm {
            scm {
                git {
                    remote { url(git_repository) }
                    scriptPath('./pipelines/Jenkinsfile.release')
                    branch('*/master')
                    // Prevents tagging the repo
                    extensions {}
                }
            }
        }
    }
}