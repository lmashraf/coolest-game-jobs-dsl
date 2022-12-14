pipelineJob('build-coolest-game-all-debug')
{
    def git_repository = 'https://' + System.getenv('git_token') + '@github.com/lmashraf/coolest-game.git'

    description("Pipeline to build and test Debug version of the Coolest Game Project")

    definition
    {
        cpsScm {
            scm {
                git {
                    remote { url(git_repository) }
                    scriptPath('./pipelines/Jenkinsfile.debug')
                    branch('*/master')
                    // Prevents tagging the repo
                    extensions {}
                }
            }
        }
    }
}