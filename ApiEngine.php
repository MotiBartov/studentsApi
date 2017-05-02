<?php 
require_once 'ApiKernel.php';

class ApiEngine extends ApiKernel
{
    protected $User;

    public function __construct($request, $origin) {
        parent::__construct($request);

        // Abstracted out for example
        //$APIKey = new Models\APIKey();
        //$User = new Models\User();

/*
        if (!array_key_exists('apiKey', $this->request)) {
            throw new Exception('No API Key provided');
        } else if (!$APIKey->verifyKey($this->request['apiKey'], $origin)) {
            throw new Exception('Invalid API Key');
        } else if (array_key_exists('token', $this->request) &&
             !$User->get('token', $this->request['token'])) {

            throw new Exception('Invalid User Token');
        }

        $this->User = $User;
         */
    }

     /**
     * student endpoint
     */
     protected function student($args) {

        if ($this->method == 'GET') {
        	if(isset($_GET['id'])){ //Getting a student from the repository
                $id = intval($_GET['id']);
                if( !is_numeric($id) || $id > ( count($this->repository->getStudents()) - 1)){
                    return '';
                }else{
                    return json_encode($this->repository->getStudents()[ $id ]);
                }
    	    }else{  //Getting all students in the repository
               return '{results:'.json_encode($this->repository->getStudents()).'}';
     	    }
        } else {
            return "Only accepts GET requests";
        }
     }
 }

?>