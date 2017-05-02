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
     * Example of an Endpoint
     */
     protected function student($args) {

        if ($this->method == 'GET') {
        	if(isset($_GET['id'])){
         //	echo 'student endpoint '.$_GET['id'];
                //return json_encode(array('firstname' => 'moti', 'lastname' => 'bartov', 'id' => '031992654'));

                return json_encode($this->repository->getRepo()[intval($_GET['id'])]);
    	    }else{
    	    	$student1 = array('firstname' => 'moti', 'lastname' => 'bartov', 'id' => '031992654');
    	    	$student2 = array('firstname' => 'Donald', 'lastname' => 'Trump', 'id' => '55555555');

               return '{results:'.json_encode($this->repository->getRepo()).'}';
     	    }
        } else {
            return "Only accepts GET requests";
        }
     }
 }

?>