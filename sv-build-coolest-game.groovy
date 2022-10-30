pipelineJob('nv-build-coolest-game')
{
    def git_repository = 'https://${personal_token}:github.com/lmashraf/coolest-game'

    description("Pipeline to run Submit Verification pipeline for Coolest Game Project")

    definition
    {
        cpsScm {
            scm {
                git {
                    remote { url(git_repository) }
                    scriptPath('./Jenkinsfile')
                    branch('*/master')
                    // Prevents tagging the repo
                    extensions {}
                }
            }
        }
    }
}